package app.bastiannolte

data class SampleEntity(val fullname: String, override val uuid: String?): WithUuid
