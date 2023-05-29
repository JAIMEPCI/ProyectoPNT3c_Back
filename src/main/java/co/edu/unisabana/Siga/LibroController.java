package co.edu.unisabana.Siga;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static co.edu.unisabana.Siga.CategoriaEnum.*;

@RestController
@RequestMapping("/libreria")

public class LibroController {
    List<LibroDTO> listaLibros;

    public LibroController() {
        this.listaLibros = new ArrayList<>();

        listaLibros.add(new LibroDTO(1, "La Odisea", "Homero", CIENTIFICO, true));
        listaLibros.add(new LibroDTO(2, "Cien años de soledad", "Gabriel García Márquez", LITERATURA, true));
        listaLibros.add(new LibroDTO(3, "El Quijote", "Miguel de Cervantes", LINGUISTICO, true));
        listaLibros.add(new LibroDTO(4, "Viaje al centro de la Tierra", "Julio Verne", VIAJE, false));
        listaLibros.add(new LibroDTO(5, "Diario de Anne Frank", "Anne Frank", BIOGRAFIA, false));
        listaLibros.add(new LibroDTO(6, "El Principito", "Antoine de Saint-Exupéry", RECREATIVO, true));
        listaLibros.add(new LibroDTO(7, "Poemas de amor", "Pablo Neruda", POETICO, false));
        listaLibros.add(new LibroDTO(8, "Harry Potter y la piedra filosofal", "J.K. Rowling", JUVENIL, true));
        listaLibros.add(new LibroDTO(9, "1984", "George Orwell", FICCION, false));
        listaLibros.add(new LibroDTO(10, "Orgullo y prejuicio", "Jane Austen", COMEDIA, true));
        listaLibros.add(new LibroDTO(11, "Don Quijote de la Mancha", "Miguel de Cervantes", CIENTIFICO, true));
        listaLibros.add(new LibroDTO(12, "Cien años de soledad", "Gabriel García Márquez", LITERATURA, true));
        listaLibros.add(new LibroDTO(13, "Ulises", "James Joyce", LINGUISTICO, true));
        listaLibros.add(new LibroDTO(14, "Steve Jobs", "Walter Isaacson", BIOGRAFIA, true));
        listaLibros.add(new LibroDTO(15, "Rimas", "Gustavo Adolfo Bécquer", POETICO, true));
        listaLibros.add(new LibroDTO(16, "Harry Potter y el prisionero de Azkaban", "J.K. Rowling", JUVENIL, true));
        listaLibros.add(new LibroDTO(17, "1984", "George Orwell", FICCION, false));
        listaLibros.add(new LibroDTO(18, "La importancia de llamarse Ernesto", "Oscar Wilde", COMEDIA, true));
        listaLibros.add(new LibroDTO(19, "Crónica de una muerte anunciada", "Gabriel García Márquez", LITERATURA, true));
        listaLibros.add(new LibroDTO(20, "Las aventuras de Tom Sawyer", "Mark Twain", VIAJE, true));
        listaLibros.add(new LibroDTO(21, "El alquimista", "Paulo Coelho", LITERATURA, true));
        listaLibros.add(new LibroDTO(22, "Moby Dick", "Herman Melville", VIAJE, false));
        listaLibros.add(new LibroDTO(23, "El retrato de Dorian Gray", "Oscar Wilde", FICCION, true));
        listaLibros.add(new LibroDTO(24, "Drácula", "Bram Stoker", FICCION, false));
        listaLibros.add(new LibroDTO(25, "Los juegos del hambre", "Suzanne Collins", JUVENIL, true));
        listaLibros.add(new LibroDTO(26, "Crónicas de Narnia", "C.S. Lewis", FICCION, true));
        listaLibros.add(new LibroDTO(27, "La sombra del viento", "Carlos Ruiz Zafón", LITERATURA, true));
        listaLibros.add(new LibroDTO(28, "Crimen y castigo", "Fyodor Dostoyevsky", LITERATURA, false));
        listaLibros.add(new LibroDTO(29, "El gran Gatsby", "F. Scott Fitzgerald", LITERATURA, true));
        listaLibros.add(new LibroDTO(30, "Donde los árboles cantan", "Laura Gallego", FICCION, true));
        listaLibros.add(new LibroDTO(31, "Los pilares de la Tierra", "Ken Follett", CIENTIFICO, false));
        listaLibros.add(new LibroDTO(32, "El código Da Vinci", "Dan Brown", JUVENIL, true));
        listaLibros.add(new LibroDTO(33, "1984", "George Orwell", FICCION, true));
        listaLibros.add(new LibroDTO(34, "Orgullo y prejuicio", "Jane Austen", JUVENIL, true));
        listaLibros.add(new LibroDTO(35, "El nombre del viento", "Patrick Rothfuss", RECREATIVO, false));
        listaLibros.add(new LibroDTO(36, "El amor en los tiempos del cólera", "Gabriel García Márquez", POETICO, true));
        listaLibros.add(new LibroDTO(37, "Cien años de soledad", "Gabriel García Márquez", LITERATURA, true));
        listaLibros.add(new LibroDTO(38, "El señor de los anillos", "J.R.R. Tolkien", FICCION, false));


        listaLibros.add(new LibroDTO(51,"titulo 51","autor 51",COMEDIA,true));
        listaLibros.add(new LibroDTO(52,"titulo 52","autor 52",LINGUISTICO,true));
        listaLibros.add(new LibroDTO(53,"titulo 53","autor 51",BIOGRAFIA,true ));
        listaLibros.add(new LibroDTO(54,"titulo 54","autor 54",VIAJE,false ));
        listaLibros.add(new LibroDTO(55,"titulo 55","autor 51",COMEDIA,false ));
        listaLibros.add(new LibroDTO(56,"titulo 56","autor 56",COMEDIA,true ));
        listaLibros.add(new LibroDTO(57,"titulo 57","autor 57",FICCION,false ));

    }

    @GetMapping(path = "/todos")
    public List<LibroDTO> obtenerLibros() {
        return listaLibros;
    }


    @GetMapping(path = "/categoria")
    public List<LibroDTO> obtenerLibrosPorCategoria(@RequestParam CategoriaEnum categoria, @RequestParam int cantidadLibros) {
        List<LibroDTO> busqueda = new ArrayList<>();
        int contador = 0;
        for (LibroDTO libro : listaLibros) {
            if (libro.getCategoria().equals(categoria) && contador < cantidadLibros) {
                busqueda.add(libro);
                contador++;
            }
        }
        return busqueda;
    }

    @GetMapping(path = "/titulo")
    public List<LibroDTO> obtenerLibrosPorTitulo(@RequestParam String titulo, @RequestParam int cantidadLibros) {
        List<LibroDTO> busqueda = new ArrayList<>();
        int contador = 0;
        for (LibroDTO libro : listaLibros) {
            if (libro.getTitulo().equals(titulo) && contador < cantidadLibros) {
                busqueda.add(libro);
                contador++;
            }
        }
        return busqueda;
    }

    @GetMapping(path = "/autor")
    public List<LibroDTO> obtenerLibrosPorAutor(@RequestParam String autor, @RequestParam int cantidadLibros) {
        List<LibroDTO> busqueda = new ArrayList<>();
        int contador = 0;
        for (LibroDTO libro : listaLibros) {
            if (libro.getTitulo().equals(autor) && contador < cantidadLibros) {
                busqueda.add(libro);
                contador++;
            }
        }
        return busqueda;
    }
}