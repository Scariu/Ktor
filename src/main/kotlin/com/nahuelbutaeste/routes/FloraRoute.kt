package com.nahuelbutaeste.routes

import com.nahuelbutaeste.data.model.Flora
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

private const val baseUrl = "http://localhost:8100"

private val flora = listOf(
    Flora(
        1,
        "Araucaria",
        "Araucaria Araucana",
        "$baseUrl/floraimg/araucaria.jpg",
        "Araucariaceae",
        "Plantae",
        94,
        "Construcción, carpintería, ornamental, alimenticio, medicinal, cultural",
        "En peligro",
        "Árbol",
        "Especie arbórea endémica del distrito del Pehuén, en la Patagonia argentina, principalmente en el centro-norte de la provincia de Neuquén y en el centro-sur de Chile.  Es un árbol perenne de hasta 50 metros de altura que crece en suelos arcillosos y volcánicos. Es una especie de lento desarrollo y larga vida, alcanzando los 1021 años. Su semilla, el piñón, es comestible y constituye la base de la dieta tradicional de los pehuenches. Fue declarado monumento natural el 26 de abril de 1976.",
        "Provincia de Neuquén(Argentina) y centro-sur de Chile"
    ),
    Flora(
        2,
        "Lenga",
        "Nothofagus pumilio",
        "$baseUrl/floraimg/lenga.jpg",
        "Nothofagaceae",
        "Plantae",
        2,
        "Elaboración de muebles, tejas, construcción, fabricación de armarios",
        "Preocupación menor",
        "Árbol",
        "Especie representativa del bosque andino patagónico que se encuentra en Chile desde la región del Maule hasta Magallanes  y en Argentina desde Neuquén hasta Tierra del Fuego. Dependiendo del sitio donde crezca puede alcanzar más de 30 metros de altura.  Puede tolerar −20 °C y heladas todos los meses del año. Se recupera después de incendios.",
        "Sur de la Cordillera de los Andes e Isla Grande de Tierra del Fuego"
    ),
    Flora(
        3,
        "Coigüe",
        "Nothofagus dombeyi",
        "$baseUrl/floraimg/coigue.jpg",
        "Nothofagaceae",
        "Plantae",
        12,
        "Carpintería, leña, ornamental.",
        "Preocupación menor",
        "Árbol",
        "Es un árbol perenne y frondoso, de corteza castaña-gris oscura, que crece en el centro y sur de Chile y en el Sudoeste de Argentina. Puede llegar a medir entre 35 a 45 metros de altura y permanecer en pie hasta 600 años. Se encuentra protegido en distintas reservas y parques tanto en Chile como en Argentina.",
        "Entre regiones de O'Higgins y Aysén (Chile). En Argentina se encuentra en las provincias de Neuquén, Río Negro y Noroeste de Chubut."
    ),
    Flora(
        4,
        "Ñirre",
        "Nothofagus antarctica",
        "$baseUrl/floraimg/nirre.jpg",
        "Nothofagaceae",
        "Plantae",
        35,
        "Leña, ornamental",
        "Preocupación menor",
        "Árbol",
        "Árbol caducifolio que se distribuye entre las regiones de O’Higgins y Magallanes en Chile. Crece principalmente en áreas de los Andes y en la isla de Tierra del Fuego. Alcanzan una altura entre 10 y 25 metros. Sus hojas desaparecen completamente durante el invierno. Su nombre proviene de la lengua mapuche, donde nire significa zorro, los cuales suelen hacer sus madrigueras debajo de estos árboles",
        "Bosque andino patagónico"
    ),
    Flora(
        5,
        "Queule",
        "Gomortega keule",
        "$baseUrl/floraimg/queule.jpg",
        "Gomortegaceae",
        "Plantae",
        18,
        "comestible, forestal, ornamental.",
        "En peligro",
        "Árbol",
        "Suele medir alrededor de 15 metros de altura. Son árboles perennifolios que poseen flores verdosas y un fruto superficialmente similar a una ciruela, que es comestible y se emplea en la producción de mermelada y chicha.. Actualmente esta especie está altamente amenazada por el reemplazo de bosques nativos o reforestación de su hábitat con plantaciones de Pinus radiata, por la deforestación de terrenos para la agricultura y la sobreexplotación de la madera. Posee escasa o nula regeneración natural, producto de su propia baja tasa de germinación. Es considerado como una especie en peligro de extinción. El Gobierno de Chile declaró a esta especie Monumento Natural, quedando prohibida su tala.",
        "Cordillera de la Costa entre la provincia de Cauquenes y provincia de Arauco. También se observa esta especie desde las regiones de la Araucanía  a Los Lagos."
    ),
    Flora(
        6,
        "Peumo",
        "Cryptocarya alba",
        "$baseUrl/floraimg/peumo.jpg",
        "Lauraceae",
        "Plantae",
        26,
        "ornamental, apícola, frutícola, comestible, medicinal, teñido de lana,  fabricación de hormas de zapatos y piezas de carreta.",
        "Preocupación menor",
        "Árbol",
        "Árbol monoico que tiene hojas perennes y aromáticas.  Florece de noviembre a enero. Las flores se encuentran en racimos densos y poseen seis pétalos carnosos y desiguales. Presenta un fruto comestible de color rojo llamado “peumo”, con semillas grandes, pesadas y de fácil germinación. Esta especie prospera en sitios húmedos del bosque esclerófilo. No supera los 25 metros de altura y dependiendo del clima puede achaparrarse en arbusto.",
        "Desde el sur de la región de Coquimbo hasta la región de la Araucanía"
    ),
    Flora(
        7,
        "Radal",
        "Lomatia hirsuta",
        "$baseUrl/floraimg/radal.jpg",
        "Proteaceae",
        "Plantae",
        41,
        "Ornamental, leña, artesanía, muebles,  teñido de lana, medicinal",
        "Preocupación menor",
        "Árbol",
        "El radal o nogal silvestre crecen en Chile desde la región de Coquimbo a la región de Los Lagos. Cohabita con especies como el Ciprés de la Cordillera y el  Maitén. Se reproduce por semillas y rebrota del tocón.",
        "Bosques templados de Chile y Argentina"
    ),
    Flora(
        8,
        "Litre",
        "Lithrea caustica",
        "$baseUrl/floraimg/litre.jpg",
        "Anacardiaceae",
        "Plantae",
        91,
        "Ornamental, industrial, gastronómico, producción de bebidas alcohólicas",
        "Preocupación menor",
        "Árbol",
        "Especie leñosa, especialmente conocido por la fuerte reacción alérgica que puede llegar a producir sus hojas al entrar en contacto con la piel.",
        "Regiones de Coquimbo y Bio Bio"
    ),
    Flora(
        9,
        "Copihue",
        "Lapageria rosea",
        "$baseUrl/floraimg/copihue.jpg",
        "Philesiaceae",
        "Plantae",
        19,
        "Ornamental, medicinal, comestible, cestería",
        "Casi amenazado",
        "Flor",
        "Planta enredadera perennifolia que florece entre febrero y julio. Aunque la UICN no ha evaluado su estado de conservación, el gobierno chileno la declaró en grave peligro de extinción debido a la extracción indiscriminada, prohibiéndose el arranque, la corta total o parcial, el transporte y comercialización de sus plantas y flores , así como su tenencia en lugares de venta o vía pública. Fue oficialmente declarada flor nacional de Chile el 24 de febrero de 1977",
        "Bosques templados del centro y sur de Chile"
    ),
    Flora(
        10,
        "Añañuca",
        "Rhodophiala rhodolirion",
        "$baseUrl/floraimg/ananuca.jpg",
        "Amaryllidaceae",
        "Plantae",
        85,
        "Ornamental",
        "Vulnerable",
        "Flor",
        "Planta herbácea perenne. Amenazada por pérdida de hábitat.",
        "Chile y Argentina, en ambos lados de la Cordillera de los Andes"
    )
)

fun Route.allFlora() {
    get("/flora") {
        call.respond(
            HttpStatusCode.OK, flora
        )
    }
}