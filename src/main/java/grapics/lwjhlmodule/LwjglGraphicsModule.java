package grapics.lwjhlmodule;


import exception.ErrorCatcher;
import grapics.GraphicsModule;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Color;

import static org.lwjgl.opengl.GL11.*;
import constant.Constants;



/**
 * Реализует графический модуль игры на основе LWJGL
 *
 * @author Zabogonski
 * @version 1.0
 */
public class LwjglGraphicsModule implements GraphicsModule {

    /*
    * Конструктор. Инициализирует графический дивжок и необходимы поля модуля.
    * */
    public LwjglGraphicsModule(){
        initOpenGL();
    }

    private void initOpenGL(){
        try{
            Display.setDisplayMode(new DisplayMode(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
            Display.setTitle(Constants.SCREEN_NAME);
            Display.create();
        } catch (LWJGLException e) {
            ErrorCatcher.graphicsFailure(e);
        }

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Constants.SCREEN_WIDTH, 0, Constants.SCREEN_HEIGHT, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        //Для поддержки текстур
        glEnable(GL_TEXTURE_2D);
        //Для поддержки прозрачности
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        //Белый фоновый цвет
        glClearColor(1, 1, 1, 1);
    }

    /**
     * Отрисовывает отдельную ячейку
      * @param x Координаты отрисовки x
     * @param y Координаты отрисовки y
     * @param color Цвет ячейки
     */
    private void drawCell(int x, int y, Color color){
        glColor3b(color.getRedByte(), color.getGreenByte(), color.getBlueByte());
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2f(x, y + Constants.CELL_SIZE);
        glTexCoord2f(1, 0);
        glVertex2f(x + Constants.CELL_SIZE, y + Constants.CELL_SIZE);
        glTexCoord2f(1, 1);
        glVertex2f(x + Constants.CELL_SIZE, y);
        glTexCoord2f(0, 1);
        glVertex2f(x, y);
        glEnd();
    }

    @Override
    public void draw(GameField field) {

    }

    @Override
    public boolean isCloseRequested() {
        return false;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void sync(int fps) {

    }
}
