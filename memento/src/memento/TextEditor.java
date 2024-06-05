package memento;

public class TextEditor {
	public static void main(String[] args) {
        TextDocument document = new TextDocument();
        DocumentHistory history = new DocumentHistory();

        document.setContent("Version 1");
        history.save(document);
        System.out.println("Current Content: " + document.getContent());

        document.setContent("Version 2");
        history.save(document);
        System.out.println("Current Content: " + document.getContent());

        document.setContent("Version 3");
        history.save(document);
        System.out.println("Current Content: " + document.getContent());

        history.undo(document);
        System.out.println("After undo: " + document.getContent());

        history.undo(document);
        System.out.println("After second undo: " + document.getContent());

        history.redo(document);
        System.out.println("After redo: " + document.getContent());
    }

}
