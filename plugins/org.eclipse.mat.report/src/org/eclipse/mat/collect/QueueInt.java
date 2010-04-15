/*******************************************************************************
 * Copyright (c) 2008 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API and implementation
 *******************************************************************************/

package org.eclipse.mat.collect;

import org.eclipse.mat.report.internal.Messages;

/**
 * A simple queue of ints
 * @since 0.8
 */
public class QueueInt
{
    int[] data;
    int headIdx;
    int tailIdx;
    int size;
    int capacity;

    /**
     * Create a queue of specified initial capacity.
     * The queue can grow if required.
     * @param capacity the initial capacity
     */
    public QueueInt(int capacity)
    {
        this.capacity = capacity;
        data = new int[capacity];
    }

    /**
     * Retrieve the next element from the queue.
     * @return the next element
     */
    public final int get()
    {

        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(Messages.QueueInt_ZeroSizeQueue);
        int result = data[headIdx];
        headIdx++;
        size--;

        if (headIdx == capacity)
            headIdx = 0;

        return result;
    }

    /**
     * The number of elements available for retrieval.
     * @return the size
     */
    public final int size()
    {
        return size;
    }

    /**
     * Add an element to the back of the queue.
     * @param x the element to add
     */
    public final void put(int x)
    {

        if (tailIdx == capacity)
            tailIdx = 0;

        if (size == capacity)
        {
            // resize
            capacity <<= 1;
            int[] tmp = new int[capacity];
            int headToEnd = data.length - headIdx;
            System.arraycopy(data, headIdx, tmp, 0, headToEnd);
            if (tailIdx > 0)
                System.arraycopy(data, 0, tmp, headToEnd, tailIdx);

            headIdx = 0;
            tailIdx = data.length;

            data = tmp;
        }

        data[tailIdx] = x;
        size++;
        tailIdx++;
    }

}
