public class TESTJAVA {
    public static BufFood comida1 = new BufFood("MANZANA", 1, 2);
    public static Animal[] listMio = {new Animal("Mosquito", 2, 2, ListAnimal.Volador, null), new MascotaNo("Hormiga", "Compañerismo", 1, 2, ListAnimal.Insecto, ListAnimal.Terrestre), new MascotaNo("Hormiga", "Compañerismo", 1, 2, ListAnimal.Insecto, ListAnimal.Terrestre)};
    public static Animal[] listBot = {new Animal("Mosquito", 2, 2, ListAnimal.Volador, null), new Animal("Mosquito", 2, 2, ListAnimal.Volador, null), new Animal("Mosquito", 2, 2, ListAnimal.Volador, null)};
    public static void main(String[] args) {
        Mosquito.comer(comida1);
        Mosquito.comer(comida1);
        Mosquito.comer(comida1);
        Mosquito.comer(comida1);
        Mosquito.comer(comida1);
        int select = listMio.length - 1;
        int selectBot = listMio.length - 1;
        while (select >= 0 && selectBot >= 0) {
            System.out.println("Vida hormiga" + listMio[select].getLife() + "    Vidad Mosquito" + listBot[selectBot].getLife());
            System.out.println("HORMIGA VS MOSQUETI RONTDA 1");
            listMio[select].attackAnimal(listBot[selectBot]);
            listBot[selectBot].attackAnimal(listMio[select]);
            select = estaMuerto(select, listMio);
            selectBot = estaMuerto(selectBot, listBot);
        }
        String gandor = (select > selectBot) ? "Yo gane" : "yo perdi";
        System.out.println(gandor);
        System.out.println("MI LISTADO BOT");
        for (Animal animal : listBot) {
            System.out.println("Vida " + animal.getName() + animal.getLife() + "  tipo  " + printTipo(animal.getTipo()) + "/" + printTipo(animal.getTipo2()));
        }
        System.out.println("MI LISTADO");
        for (Animal animal : listMio) {
            System.out.println("Vida " + animal.getName() + animal.getLife() + "   tipo   " + printTipo(animal.getTipo()) + "/" + printTipo(animal.getTipo2()));
        }
    }

    public static int estaMuerto(int select, Animal[] listMio) {
        if (listMio[select].getLife() > 0) {
            select--;
            return (select >= 0) ? select : -1;
        }
        return -1;
    }

    public static String printTipo(ListAnimal tipo) {
        if (tipo != null) {
            return tipo + "";
        } else {
            return "";
        }
    }
}