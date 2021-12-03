package du.sample.techbox.handler

import io.ktor.application.*
import io.ktor.util.pipeline.*

typealias Handler = suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit