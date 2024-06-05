package memento;
import java.util.Stack;
public class DocumentHistory {
	private final Stack<DocumentMemento> undoStack = new Stack<>();
    private final Stack<DocumentMemento> redoStack = new Stack<>();

    public void save(TextDocument document) {
        undoStack.push(document.save());
        redoStack.clear();  // Clear redo stack whenever a new state is saved
    }

    public void undo(TextDocument document) {
        if (!undoStack.isEmpty()) {
            redoStack.push(document.save());
            document.restore(undoStack.pop());
        }
    }

    public void redo(TextDocument document) {
        if (!redoStack.isEmpty()) {
            undoStack.push(document.save());
            document.restore(redoStack.pop());
        }
    }

}
