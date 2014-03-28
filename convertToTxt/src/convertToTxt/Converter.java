package convertToTxt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;

public class Converter {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Input directory has not been provided");
			System.exit(0);
		}
		String inputFileName = args[0];
		File inputFile = new File(inputFileName);
		if (!inputFile.exists()) {
			System.err.println("Input file doesn't exist: " + inputFileName);
			System.exit(0);
		}
		convertFile(args[0]);
	}

	private static void convertFile(String inputFileName) {
		int folder = inputFileName.lastIndexOf("/");
		if (folder == -1)
			folder = 0;
		int extension = inputFileName.lastIndexOf(".");
		String outputFileName = "output\\";
		outputFileName += (inputFileName.substring(folder, extension));
		outputFileName += (".txt");
		try {
			File outputDirectory = new File("output");
			outputDirectory.mkdirs();
			File outputFile = new File(outputFileName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
			String content = extractContent(inputFileName);
			if (content != null) {
				bw.write(content);
			}
			bw.close();
		} catch (OfficeXmlFileException e) {
			System.err.println("Word document is not correctly configurated: "
					+ inputFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String extractContent(String inputFileName)
			throws OfficeXmlFileException, IOException {
		if (inputFileName.contains(".doc") && !inputFileName.contains(".docx")) {
			return docReader(inputFileName);
		}
		if (inputFileName.contains(".docx")) {
			return docxReader(inputFileName);
		}
		if (inputFileName.contains(".pdf")) {
			return pdfReader(inputFileName);
		}
		return null;
	}

	private static String docxReader(String inputFileName)
			throws OfficeXmlFileException, IOException {
		String content = "";
		XWPFDocument doc = new XWPFDocument(new FileInputStream(inputFileName));
		List<XWPFParagraph> paragraphs = doc.getParagraphs();
		for (XWPFParagraph p : paragraphs) {
			content = content + " " + p.getText();
		}
		return content;
	}

	private static String docReader(String inputFileName)
			throws IOException {
		String content = "";
		POIFSFileSystem fs = null;
		fs = new POIFSFileSystem(new FileInputStream(inputFileName));
		HWPFDocument doc = new HWPFDocument(fs);
		WordExtractor we = new WordExtractor(doc);
		String[] paragraphs = we.getParagraphText();
		for (int i = 0; i < paragraphs.length; i++) {
			content = content + " " + paragraphs[i].toString();
		}
		we.close();
		return content;
	}

	private static String pdfReader(String inputFileName)
			throws IOException {
		String content = "";
		PdfReader reader = new PdfReader(inputFileName);
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			byte[] streamBytes = reader.getPageContent(i);
			PRTokeniser tokenizer = new PRTokeniser(
					new RandomAccessFileOrArray(
							new RandomAccessSourceFactory()
									.createSource(streamBytes)));
			while (tokenizer.nextToken()) {
				if (tokenizer.getTokenType() == PRTokeniser.TokenType.STRING) {
					content += tokenizer.getStringValue();
				}
			}
			tokenizer.close();
		}
		reader.close();
		return content;
	}
}
