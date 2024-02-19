// AbstractFactory

// interface Scaleable {  
//     static final int BIG = 0, MEDIUM = 1, SMALL = 2;  
//     void setScale( int size );  
// }

interface IButton {
    void press();
}

class MacButton implements IButton {
    public void press() {
        System.out.println("Mac Button Pressed");
    }
}

class WinButton implements IButton {
    public void press() {
        System.out.println("Win Button Pressed");
    }
}

interface ITextBox {
    void showText();
}

class MacTextBox implements ITextBox {
    public void showText() {
        System.out.println("Showing Mac TextBox");
    }
}

class WinTextBox implements ITextBox {
    public void showText() {
        System.out.println("Showing Win Button Pressed");
    }
}

interface IFactory {
    IButton createButton();

    ITextBox createTextBox();
}

class MacFactory implements IFactory {
    public IButton createButton() {
        return new MacButton();
    }

    public ITextBox createTextBox() {
        return new MacTextBox();
    }
}

class WinFactory implements IFactory {
    public IButton createButton() {
        return new WinButton();
    }

    public ITextBox createTextBox() {
        return new WinTextBox();
    }
}

public class GUIAbstractFactory {
    public static IFactory createFactory(String osType) {
        if (osType.equalsIgnoreCase("windows")) {
            return new WinFactory();
        } else if (osType.equalsIgnoreCase("mac")) {
            return new MacFactory();
        } else {
            return new MacFactory();
        }
    }
}
