package Task_4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Document document1 = new Document(1, "file1", 98);
        Document document2 = new Document(2, "file2", 78);
        Document document3 = new Document(3, "file3", 45);
        ArrayList<Document> documents = new ArrayList<>();
        documents.add(document1);
        documents.add(document2);
        documents.add(document3);
        System.out.println(Document.organizeDocuments(documents));
    }
}
