/***************************************************************************
 * Bytecode Viewer (BCV) - Java & Android Reverse Engineering Suite        *
 * Copyright (C) 2014 Konloch - Konloch.com / BytecodeViewer.com           *
 *                                                                         *
 * This program is free software: you can redistribute it and/or modify    *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation, either version 3 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>. *
 ***************************************************************************/

package the.bytecode.club.bytecodeviewer.gui.contextmenu.resourcelist;

import the.bytecode.club.bytecodeviewer.BytecodeViewer;
import the.bytecode.club.bytecodeviewer.gui.contextmenu.ContextMenuItem;
import the.bytecode.club.bytecodeviewer.gui.contextmenu.ContextMenuType;
import the.bytecode.club.bytecodeviewer.translation.TranslatedStrings;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Konloch
 * @since 7/26/2021
 */
public class Delete extends ContextMenuItem
{
    public Delete()
    {
        super(ContextMenuType.CONTAINER, ((tree, selPath, result, menu) -> menu.add(new AbstractAction(TranslatedStrings.DELETE.toString())
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //remove memory reference
                BytecodeViewer.viewer.resourcePane.deletePath(selPath);

                //remove gui reference
                BytecodeViewer.viewer.resourcePane.removeNode(tree, selPath);
            }
        })));
    }
}
