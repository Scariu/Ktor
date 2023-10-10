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
        "Austrochilus",
        "Esta araña es bien interesante por que hace unas telas de araña gigantes (he visto de más de un metro) y de estructura muy irregular en los bosques del centro y sur de Chile. De día es imposible encontrarla, pero de noche siempre sale y se queda colgando en la tela de araña hacia abajo.",
        "$baseUrl/faunaimg/spider.jpg"
    ),
    Fauna(
        "Puma concolor",
        "El puma (Puma concolor) también es conocido como “león de montaña o león americano”, “trapial” (mapuche). Es el carnívoro terrestre más grande que habita en Chile,\n",
        "$baseUrl/faunaimg/puma.jpg"
    ),
    Fauna(
        "Buteo(Busardo patagón)",
        "El adulto es café negruzco por encima. La garganta es blanca con bigotes negros. El pecho es ocre con finas pintas longitudinales negras. El abdomen es blanquecino con pintas café acaneladas especialmente hacia los flancos. Las calzas son acaneladas con barras transversales café rojizas.",
        "$baseUrl/faunaimg/buteo.jpg"
    ),
    Fauna(
        "Búho campestre",
        "es una de las rapaces nocturnas con mayor actividad diurna",
        "$baseUrl/faunaimg/buho.jpg"
    ),
    Fauna(
        "Abejorro",
        "Los abejorros son abejas relativamente grandes de veinte milímetros o más. Las reinas son más grandes que las obreras y que los zánganos.",
        "$baseUrl/faunaimg/abejorro.jpg"
    ),
    Fauna(
        "Rana Narigona",
        "Especie de pequeño tamaño, con aproximadamente 2,0 cm de longitud. Su dorso es marrón con franjas longitudinales",
        "$baseUrl/faunaimg/rana.jpg"
    ),
    Fauna(
        "Peorro",
        "Como mecanismo de defensa ante amenazas, el peorro expulsa una sustancia orgánica nauseabunda desde glándulas perianales que posee para tal fin, provocando un efecto irritante de efecto pasajero pero bastante molesto.",
        "$baseUrl/faunaimg/peorro.jpg"
    ),
    Fauna(
        "Pudú",
        "Después del pudú del norte, es el cérvido más pequeño del mundo, alcanzando entre 36 a 41 cm de altura y entre 7 y 10 kg de peso. Tiene un pelaje áspero y espeso, de color pardo-oscuro, posee una cola pequeña y las glándulas preorbitales grandes. El macho tiene cuernos cortos, mientras que la hembra carece de ellos.",
        "$baseUrl/faunaimg/pudu.jpg"
    )
)

fun Route.allFauna() {
    get("/fauna") {
        call.respond(
            HttpStatusCode.OK, fauna
        )
    }
}