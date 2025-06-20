package Week1_DesignPrinciplesAndPatterns.Exercise2_FactoryMethodPattern.Code;


interface Document{
    void open();
}

class WordDoc implements Document {
    public void open(){
        System.out.println("Opening the word Document...");
        System.out.println();
    }
}

class PDFDoc implements  Document{
    public void open(){
        System.out.println("Opening the PDF Document...");
        System.out.println();
    }
}

class ExcelDoc implements Document {
    public void open(){
        System.out.println("Opening the Excel Document...");
        System.out.println();
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocFactory extends DocumentFactory{
    public Document createDocument(){
        System.out.println("Creating the Word Doc");
        return new WordDoc();
    }
}

class PDFDocFactory extends DocumentFactory{
    public Document createDocument(){
        System.out.println("Creating the PDF Doc");
        return new PDFDoc();
    }
}

class ExcelDocFactory extends DocumentFactory{
    public Document createDocument(){
        System.out.println("Creating the Excel Doc");
        return new ExcelDoc();
    }
}

public class FactoryMethodPatternExample {

    public static void main(String[] args) {
        DocumentFactory WordFac = new WordDocFactory();
        Document wordDoc = WordFac.createDocument();
        wordDoc.open();

        DocumentFactory PDFFac = new PDFDocFactory();
        Document pdfDoc = PDFFac.createDocument();
        pdfDoc.open();

        DocumentFactory ExcelFac = new ExcelDocFactory();
        Document ExcelDoc = ExcelFac.createDocument();
        ExcelDoc.open();
    }

}
