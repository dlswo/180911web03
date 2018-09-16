package org.aram;

import org.aram.dao.CafeDAO;

public class main {
    public static void main(String[] args) {
        CafeDAO dao = new CafeDAO();
        System.out.println(dao.getList());
    }
}
