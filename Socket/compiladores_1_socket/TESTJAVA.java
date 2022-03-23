public class TESTJAVA {
    public int p = 15+((1));
    public static BufFood comida1 = new BufFood("MANZANA", 1, 2);
    public static Animal[] listMio = {new Animal("Mosquito", 2, 2, ListAnimal.Volador, null), new MascotaNo("Hormiga", "Compañerismo", 1, 2, ListAnimal.Insecto, ListAnimal.Terrestre), new MascotaNo("Hormiga", "Compañerismo", 1, 2, ListAnimal.Insecto, ListAnimal.Terrestre)};
    public static Animal[] listBot = {new Animal("Mosquito", 2, 2, ListAnimal.Volador, null), new Animal("Mosquito", 2, 2, ListAnimal.Volador, null), new Animal("Mosquito", 2, 2, ListAnimal.Volador, null)};
    public int valor= comida1.getLife();
    public int contadorFinal = listBot.length;
    public boolean primerBoolean = (32<0);
    public boolean segundoBoolean = primerBoolean;
    public boolean tercerBoolean ;
    public static void main(String[] args) {
        int day = 5;
        String dayString;
         
        // instrucción switch con tipo de datos int
        switch (day) 
        {
            case 1:  dayString = "Lunes";
                     break;
            case 2:  dayString = "Martes";
                     break;
            case 3:  dayString = "Miercoles";
                     break;
            case 4:  dayString = "Jueves";
                     break;
            case 5:  dayString = "Viernes";
                     break;
            case 6:  dayString = "Sabado";
                     break;
            case 7:  dayString = "Domingo";
                     break;
            default: dayString = "Dia inválido";
                     break;
        }
        System.out.println(dayString);
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