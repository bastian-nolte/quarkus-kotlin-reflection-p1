package app.bastiannolte

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): SampleEntity {
        val sampleEntity = SampleEntity("Bugs Bunny", null)
        return createCopyWithUuid(sampleEntity)
    }
}
