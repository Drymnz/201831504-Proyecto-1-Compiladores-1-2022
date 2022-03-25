/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.clientapplication.Logic.Manager;

import cunoc.clientapplication.Logic.File_Manger.FileConverter;
import java.util.ArrayList;

/**
 *
 * @author Benjamín de Jesús Pérez Aguilar
 */
public class AggregationHandler extends Thread {

    private ArrayList<String> list;
    private FileConverter usar;

    public AggregationHandler(ArrayList<String> list, FileConverter usar) {
        this.list = list;
        this.usar = usar;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public FileConverter getUsar() {
        return usar;
    }

    public void setUsar(FileConverter usar) {
        this.usar = usar;
    }

    @Override
    public void run() {
        list.add(usar.upLoadTextFile());
    }

}
