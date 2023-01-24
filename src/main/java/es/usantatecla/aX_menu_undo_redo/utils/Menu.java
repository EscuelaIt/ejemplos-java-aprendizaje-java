package es.usantatecla.aX_menu_undo_redo.utils;

import java.util.ArrayList;
import java.util.List;

import es.usantatecla.utils.Console;

public abstract class Menu {

    private static Console console = new Console();
    private String title;
    private List<Option> options;

    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<Option>();
    }

    protected void deleteOptions() {
        this.options.clear();
    }

    public void interact() {
        this.addOptions();
        this.interact_();
    }

    protected abstract void addOptions();

    protected void interact_() {
        this.showTitles();
        this.execChoosedOption();
    }

    protected void showTitles() {
        this.showTitle();
        for (int i = 0; i < this.options.size(); i++) {
            this.options.get(i).showTitle(i + 1);
        }
    }

    private void showTitle() {
        String string = "\n" + this.title + "\n";
        for (int i = 0; i < this.title.length(); i++) {
            string += "-";
        }
        Menu.console.writeln(string);
    }

    protected void execChoosedOption() {
        int answer;
        boolean ok;
        do {
            answer = Menu.console.readInt("Opción? [1-" + this.options.size() + "]: ") - 1;
            ok = 0 <= answer && answer <= this.options.size() - 1;
            if (!ok) {
                Menu.console.writeln("Error!!!");
            }
        } while (!ok);
        this.options.get(answer).interact();
    }

    protected void add(Option option) {
        this.options.add(option);
    }

    protected void removeOptions() {
        this.options.clear();
    }

    protected boolean hasOption(Option option) {
        return this.options.contains(option);
    }

}