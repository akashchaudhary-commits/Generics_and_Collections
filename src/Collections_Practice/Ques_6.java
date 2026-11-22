package Collections_Practice;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

abstract class EditorAction {
    protected String actionId;
    protected int timestamp;

    public EditorAction(String actionId, int timestamp) {
        this.actionId = actionId;
        this.timestamp = timestamp;
    }

    public abstract String execute(String currentContent);
    public abstract String undo(String currentContent);
    public abstract String getActionLog();
}

class AppendTextAction extends EditorAction {
    private String textToAppend;

    public AppendTextAction(String actionId, int timestamp, String textToAppend) {
        super(actionId, timestamp);
        this.textToAppend = textToAppend;
    }

    @Override
    public String execute(String currentContent) {
        return currentContent + textToAppend;
    }

    @Override
    public String undo(String currentContent) {
        if (currentContent.length() >= textToAppend.length()) {
            return currentContent.substring(0, currentContent.length() - textToAppend.length());
        }
        return "";
    }

    @Override
    public String getActionLog() {
        return "[APPEND:" + actionId + "@" + timestamp + "] +\"" + textToAppend + "\"";
    }
}

class DeleteLastCharsAction extends EditorAction {
    private int deleteCount;
    private String deletedCache = "";

    public DeleteLastCharsAction(String actionId, int timestamp, int deleteCount) {
        super(actionId, timestamp);
        this.deleteCount = deleteCount;
    }

    @Override
    public String execute(String currentContent) {
        int actualDelete = Math.min(deleteCount, currentContent.length());
        int splitIdx = currentContent.length() - actualDelete;
        this.deletedCache = currentContent.substring(splitIdx);
        return currentContent.substring(0, splitIdx);
    }

    @Override
    public String undo(String currentContent) {
        return currentContent + deletedCache;
    }

    @Override
    public String getActionLog() {
        return "[DELETE:" + actionId + "@" + timestamp + "] -" + deleteCount + "chars";
    }
}

class DocumentHistoryManager {
    private LinkedList<EditorAction> history = new LinkedList<>();
    private ListIterator<EditorAction> cursor = history.listIterator();
    private String documentContent = "";

    public void performAction(EditorAction action) {
        // Truncate forward branch if cursor is not at tail
        while (cursor.hasNext()) {
            cursor.next();
            cursor.remove();
        }
        documentContent = action.execute(documentContent);
        cursor.add(action);
    }

    public void undo() {
        if (cursor.hasPrevious()) {
            EditorAction prev = cursor.previous();
            documentContent = prev.undo(documentContent);
        }
    }

    public void redo() {
        if (cursor.hasNext()) {
            EditorAction next = cursor.next();
            documentContent = next.execute(documentContent);
        }
    }

    public void printStatus() {
        System.out.println("Document: \"" + documentContent + "\"");
        System.out.println("History Size: " + history.size() + " | Cursor Index: " + cursor.nextIndex());
        for (EditorAction act : history) {
            System.out.println(act.getActionLog());
        }
    }
}

public class Ques_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine().trim());
        DocumentHistoryManager manager = new DocumentHistoryManager();

        for (int i = 0; i < q; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ", 4);
            String cmd = parts[0].toUpperCase();

            if (cmd.equals("APPEND")) {
                String id = parts[1];
                int ts = Integer.parseInt(parts[2]);
                String text = parts[3];
                manager.performAction(new AppendTextAction(id, ts, text));
            } else if (cmd.equals("DELETE")) {
                String id = parts[1];
                int ts = Integer.parseInt(parts[2]);
                int count = Integer.parseInt(parts[3]);
                manager.performAction(new DeleteLastCharsAction(id, ts, count));
            } else if (cmd.equals("UNDO")) {
                manager.undo();
            } else if (cmd.equals("REDO")) {
                manager.redo();
            }
        }
    }
}


