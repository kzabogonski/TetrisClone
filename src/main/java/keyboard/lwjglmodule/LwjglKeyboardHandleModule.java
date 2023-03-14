package keyboard.lwjglmodule;

import enums.ShiftDirection;
import keyboard.KeyboardHandleModule;
import org.lwjgl.input.Keyboard;

public class LwjglKeyboardHandleModule implements KeyboardHandleModule {

    private boolean wasEscPressed;

    private boolean wasRotateRequested;

    private ShiftDirection shiftDirection;

    /**
     * Считывание последних данных из стека событий
     */
    @Override
    public void update() {
        resetValues();

        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                switch (Keyboard.getEventKey()) {
                    case Keyboard.KEY_ESCAPE:
                        wasEscPressed = true;
                        break;
                    case Keyboard.KEY_UP:
                        wasRotateRequested = true;
                        break;
                    case Keyboard.KEY_LEFT:
                        shiftDirection = ShiftDirection.LEFT;
                        break;
                    case Keyboard.KEY_RIGHT:
                        shiftDirection = ShiftDirection.RIGHT;
                        break;
                }
            }
        }
    }

    /**
     * Обнуление данных, полученых при предыдущих запросах
     */
    private void resetValues() {
        wasEscPressed = false;
        wasRotateRequested = false;
        shiftDirection = ShiftDirection.AWAITING;
    }

    @Override
    public boolean wasEscPressed() {
        return wasEscPressed;
    }

    @Override
    public ShiftDirection getShiftDirection() {
        return shiftDirection;
    }

    @Override
    public boolean wasRotateRequested() {
        return wasRotateRequested;
    }

    @Override
    public boolean wasBoostRequested() {
        return Keyboard.isKeyDown(Keyboard.KEY_DOWN);
    }
}
