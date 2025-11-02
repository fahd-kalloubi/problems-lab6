package problem3;

public abstract class Document {
    protected int numRec;
    protected String title;
    private static int nextNumRec = 1;

    public Document(String title) {
        this.title = title;
        this.numRec = nextNumRec++;
    }

    public int getNumRec() {
        return numRec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Document [numRec=" + numRec + ", title=" + title + "]";
    }
}
