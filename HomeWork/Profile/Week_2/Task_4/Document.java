package Task_4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {
    public int id;
    public String name;

    public int pageCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Document(int id, String name, int pageCount) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
    }


    public static Map<Integer, Document> organizeDocuments(List<Document> documents) {
        Map<Integer, Document> res = new HashMap<Integer, Document>();
        for (Document document : documents) {
            res.put(document.getId(), document);
        }
        return res;
    }
}
