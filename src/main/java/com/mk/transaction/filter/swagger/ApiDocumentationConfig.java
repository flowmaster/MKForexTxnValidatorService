/**
 * This is the swagger interface . Added here to test url based events and functional testing as like POSTMAN.
 * Here we are accepting only the application/json format for both the consumer and producer.
 * @author Sambed
 * @date 30/06/2019
 * @date last update - 
 * @change by -
 */
package com.mk.transaction.filter.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Forex trade validator demo Resource API",
                version = "V 1.0",
                title = "Forex trade transaction Resource",
                contact = @Contact(
                   name = "Sambed Pattanaik", 
                   email = "", 
                   url = ""
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json"},
        produces = {"application/json"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
)
public interface ApiDocumentationConfig {

}
