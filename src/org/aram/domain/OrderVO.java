package org.aram.domain;

import lombok.Data;

@Data
public class OrderVO {

    private int ono;
    private int mnum;
    private int qty;
    private String mname;
    private int mprice;
    private int sumprice;

}
