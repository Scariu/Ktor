package com.nahuelbutaeste.routes

import com.nahuelbutaeste.data.model.Fauna
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

private const val baseUrl = "http://localhost:8100"

private val fauna = listOf(
    Fauna(
        1,"Austrochilus",
        "Austrochilus parwis Michalik &amp; Wunderlich, 2017",
        "No Evaluado (NE)",
        "Animalia",
        "Austrochilidae",
        "Austrochilus parwis Michalik & Wunderlich, 2017",
        "Arachnida",
        "$baseUrl/faunaimg/spider.jpg",
        9,
        "",
        "Esta araña es bien interesante por que hace unas telas de araña gigantes (he visto de más de un metro) y de estructura muy irregular en los bosques del centro y sur de Chile. De día es imposible encontrarla, pero de noche siempre sale y se queda colgando en la tela de araña hacia abajo.",

        ),
    Fauna(
        2,"Puma concolor",
        "Felis concolor Linnaeus, 1771",
        "Casi amenazada (NT)",
        "Animalia",
        "Felidae",
        "P. concolor Linnaeus, 1771",
        "Mammalia",
        "$baseUrl/faunaimg/puma.jpg",
        7,
        "",
        "El puma (Puma concolor) también es conocido como “león de montaña o león americano”, “trapial” (mapuche). Es el carnívoro terrestre más grande que habita en Chile."

    ),
    Fauna(
        3,"Buteo(Busardo patagón)",
        "Buteo ventralis Gould, 1837",
        "Vulnerable (VU)",
        "Animalia",
        "Accipitridae",
        "Buteo ventralis Gould, 1837",
        "Aves",
        "$baseUrl/faunaimg/buteo.jpg",
        78,
        "",
        "El adulto es café negruzco por encima. La garganta es blanca con bigotes negros. El pecho es ocre con finas pintas longitudinales negras. El abdomen es blanquecino con pintas café acaneladas especialmente hacia los flancos. Las calzas son acaneladas con barras transversales café rojizas."

    ),
    Fauna(
        4,"Búho campestre",
        "Asio flammeus (Pontoppidan, 1763)",
        "Preocupación menor (LC)",
        "Animalia",
        "Strigidae",
        "Buteo ventralis Gould, 1837",
        "Aves",
        "$baseUrl/faunaimg/buho.jpg",
        87,
        "",
        "es una de las rapaces nocturnas con mayor actividad diurna"

    ),
    Fauna(
        5,"Abejorro",
        "Bombus dahlbomii Guérin-Méneville, 1835",
        "En peligro (EN)",
        "Animalia",
        "Apidae",
        "Bombus dahlbomii Guérin-Méneville, 1835",
        "Insecta",
        "$baseUrl/faunaimg/abejorro.jpg",
        4,
        "",
        "Los abejorros son abejas relativamente grandes de veinte milímetros o más. Las reinas son más grandes que las obreras y que los zánganos."

    ),
    Fauna(
        6,"Rana Narigona",
        "Rhinoderma darwinii Duméril & Bibron, 1841",
        "En peligro (EN)",
        "Animalia",
        "Rhinodermatidae",
        "",
        "Amphibia",
        "$baseUrl/faunaimg/rana.jpg",
        4,
        "",
        "Especie de pequeño tamaño, con aproximadamente 2,0 cm de longitud. Su dorso es marrón con franjas longitudinales"

    ),
    Fauna(
        7,"Peorro",
        "Ceroglossus chilensis (Eschscholtz, 1829",
        "No Evaluado (NE)",
        "Animalia",
        "Carabidae",
        "Ceroglossus chilensis",
        "Insecta",
        "$baseUrl/faunaimg/peorro.jpg",
        2,
        "",
        "Como mecanismo de defensa ante amenazas, el peorro expulsa una sustancia orgánica nauseabunda desde glándulas perianales que posee para tal fin, provocando un efecto irritante de efecto pasajero pero bastante molesto."

    ),
    Fauna(
        8,"Pudú",
        "Pudu puda (Molina, 1782)",
        "Vulnerable (VU)",
        "Animalia",
        "Cervidae",
        "Pudu puda (Molina, 1782)",
        "Mammalia",
        "$baseUrl/faunaimg/pudu.jpg",
        33,
        "",
        "Después del pudú del norte, es el cérvido más pequeño del mundo, alcanzando entre 36 a 41 cm de altura y entre 7 y 10 kg de peso. Tiene un pelaje áspero y espeso, de color pardo-oscuro, posee una cola pequeña y las glándulas preorbitales grandes. El macho tiene cuernos cortos, mientras que la hembra carece de ellos."

    )
)

fun Route.allFauna() {
    get("/fauna") {
        call.respond(
            HttpStatusCode.OK, fauna
        )
    }
}