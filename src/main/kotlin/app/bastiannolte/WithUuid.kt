package app.bastiannolte

import java.util.*
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response
import kotlin.reflect.full.instanceParameter

interface WithUuid {
    val uuid: String?;
}

/**
 * Returns a copy of the entity with the newly created UUID.
 *
 * @param entity The entity to be copied.
 * @return The copy of the entity with the newly created Uuid.
 */
fun <E : WithUuid> createCopyWithUuid(entity: E): E {
    if (entity::class.isData) {
        val copy = entity::class.members.first { it.name == "copy" }
        val instanceParam = copy.instanceParameter!!
        val uuid = copy.parameters.first { it.name == "uuid" }
        @Suppress("UNCHECKED_CAST")
        return copy.callBy(mapOf(instanceParam to entity, uuid to UUID.randomUUID().toString())) as E
    }
    throw WebApplicationException("No valid entity.", Response.Status.INTERNAL_SERVER_ERROR)
}
