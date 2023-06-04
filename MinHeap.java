/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;

import java.util.ArrayList;


/**
 *
 * @author deemf
 */
public class MinHeap{
    private ArrayList<Edge> heap; // The heap is stored as an ArrayList of Edge objects

    MinHeap() {
        heap = new ArrayList<>(); // Constructor initializes the heap as an empty ArrayList
    }

    public void insert(Edge elem) {
        heap.add(elem); // Add the new element to the end of the heap
        int index = heap.size() - 1; // Set the index to the last element in the heap

        // Continue swapping the new element with its parent until the heap property is restored
        while (index > 0) {
            int parentIndex = (index - 1) / 2; // Calculate the parent index
            if (heap.get(parentIndex).compareTo(elem) > 0) { // If the parent is greater than the new element
                heap.set(index, heap.get(parentIndex)); // Swap the new element with its parent
                index = parentIndex; // Update the index to the parent index
            } else {
                break; // If the parent is less than or equal to the new element, the heap property is restored, so break out of the loop
            }
        }
        heap.set(index, elem); // Set the final index to the new element
    }

    public Edge extractMin() {
        if (heap.isEmpty()) { // If the heap is empty, return null
            return null;
        }
        
        // Otherwise, remove the minimum element (first element) from the heap and store it in a variable
        Edge min = heap.get(0);

        // Set the last element in the heap to the first element and remove the last element
        Edge last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) { // If the heap is not empty
            heap.set(0, last); // Replace the first element with the last element

            int index = 0; // Start at the root index

            // Continue swapping the root with its smallest child until the heap property is restored
            while (true) {
                int child1Index = index * 2 + 1; // Calculate the index of the first child
                int child2Index = index * 2 + 2; // Calculate the index of the second child

                if (child1Index >= heap.size()) { // If the first child index is out of range, there are no more children
                    break;
                }
                
                // Otherwise, determine the index of the smallest child
                int minChildIndex = child1Index;
                if (child2Index < heap.size() && heap.get(child2Index).compareTo(heap.get(child1Index)) < 0) {
                    minChildIndex = child2Index;
                }
                
                if (heap.get(minChildIndex).compareTo(last) < 0) { // If the smallest child is less than the new root
                    heap.set(index, heap.get(minChildIndex)); // Swap the root with the smallest child
                    index = minChildIndex; // Update the index to the child index
                } else {
                    break; // If the smallest child is greater than or equal to the new root, the heap property is restored, so break out of the loop
                }
            }
            heap.set(index, last); // Set the final index to the new root
        }
        return min; // Return the minimum element that was removed from the heap
    }

    public boolean isEmpty() {
        return heap.isEmpty(); // Check if the heap is empty
    }
}
