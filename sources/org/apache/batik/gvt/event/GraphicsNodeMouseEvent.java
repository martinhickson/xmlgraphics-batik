/*****************************************************************************
 * Copyright (C) The Apache Software Foundation. All rights reserved.        *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the Apache Software License *
 * version 1.1, a copy of which has been included with this distribution in  *
 * the LICENSE file.                                                         *
 *****************************************************************************/

package org.apache.batik.gvt.event;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.AffineTransform;
import org.apache.batik.gvt.GraphicsNode;

/**
 * An event which indicates that a mouse action occurred in a graphics node.
 *
 * @author <a href="mailto:Thierry.Kormann@sophia.inria.fr">Thierry Kormann</a>
 * @version $Id$
 */
public class GraphicsNodeMouseEvent extends GraphicsNodeInputEvent {

    /**
     * The first number in the range of ids used for composite events.
     */
    static final int MOUSE_FIRST = 500;

    /**
     * The id for the "mouseClicked" event. This MouseEvent occurs when a mouse
     * button is pressed and released.
     */
    public static final int MOUSE_CLICKED = MOUSE_FIRST;

    /**
     * The id for the "mousePressed" event. This MouseEvent occurs when a mouse
     * button is pushed down.
     */
    public static final int MOUSE_PRESSED = MOUSE_FIRST + 1;

    /**
     * The id for the "mouseReleased" event. This MouseEvent occurs when a mouse
     * button is let up.
     */
    public static final int MOUSE_RELEASED = MOUSE_FIRST + 2;

    /**
     * The id for the "mouseMoved" event. This MouseMotionEvent occurs
     * when the mouse position changes.
     */
    public static final int MOUSE_MOVED = MOUSE_FIRST + 3;

    /**
     * The id for the "mouseEntered" event. This MouseEvent occurs
     * when the mouse cursor enters a graphics node's area.
     */
    public static final int MOUSE_ENTERED = MOUSE_FIRST + 4;

    /**
     * The id for the "mouseExited" event. This MouseEvent occurs when
     * the mouse cursor leaves a graphics node's area.
     */
    public static final int MOUSE_EXITED = MOUSE_FIRST + 5;

    /**
     * The id for the "mouseDragged" event. This MouseEvent
     * occurs when the mouse position changes while the "drag"
     * modifier is active (for example, the shift key).
     */
    public static final int MOUSE_DRAGGED = MOUSE_FIRST + 6;

    /**
     * The graphics node mouse events x coordinate.
     * The x value is relative to the graphics node that fired the event.
     */
    float x;

    /**
     * The graphics node mouse events y coordinate.
     * The y value is relative to the graphics node that fired the event.
     */
    float y;

    /**
     * Indicates the number of quick consecutive clicks of a mouse button.
     */
    int clickCount;

    /**
     * Constructs a new graphics node mouse event.
     * @param source the graphics node where the event originated
     * @param id the id of this event
     * @param when the time the event occurred
     * @param modifiers the modifier keys down while event occurred
     * @param x,&nbsp;y the mouse coordinates
     * @param clickCount the number of clicks
     */
    public GraphicsNodeMouseEvent(GraphicsNode source, int id,
                                  long when, int modifiers,
                                  float x, float y, int clickCount) {
        super(source, id, when, modifiers);
        this.x = x;
        this.y = y;
        this.clickCount = clickCount;
    }

    /**
     * Constructs a new graphics node mouse event from an AWT MouseEvent.
     * @param source the source where the event originated
     * @param evt the AWT mouse event which is the source of this
     *            GraphicsNodeEvent
     */
    public GraphicsNodeMouseEvent(GraphicsNode source, MouseEvent evt) {
        super(source, evt);
        this.x = evt.getX();
        this.y = evt.getY();
        this.clickCount = evt.getClickCount();
    }

    /**
     * Returns the horizontal x position of the event relative to the
     * source graphics node.
     * @return x a float indicating horizontal position relative to the node
     */
    public float getX() {
        return x;
    }

    /**
     * Returns the vertical y position of the event relative to the source node.
     * @return y a float indicating vertical position relative to the node
     */
    public float getY() {
        return y;
    }

    /**
     * Returns the (x, y) position of the event relative to the source node.
     * @return a Point object containing the x and y coordinates
     */
    public Point2D getPoint2D() {
        return new Point2D.Float(x, y);
    }

    /**
     * Return the number of mouse clicks associated with this event.
     * @return integer value for the number of clicks
     */
    public int getClickCount() {
        return clickCount;
    }
}
