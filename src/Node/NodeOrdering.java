package Node;

import Model.Ordering;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class NodeOrdering {
    public Ordering data;
    public NodeOrdering next;

    public NodeOrdering() {
    }

    public NodeOrdering(Ordering data, NodeOrdering next) {
        this.data = data;
        this.next = next;
    }

    public NodeOrdering(Ordering data) {
        this.data = data;
        next = null;
    }
}
