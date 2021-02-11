package org.acme.openapi.swaggerui;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/*

Actual:

    paths:
      /generic-with-upper-bound:
        get:
          responses:
            "200":
              description: OK
              content:
                application/json:
                  schema:
                    $ref: '#/components/schemas/OrangeDto'
    components:
      schemas:
        OrangeDto:
          type: object
          properties:
            id:
              type: string

Expected:

    paths:
      /generic-with-upper-bound:
        get:
          responses:
            "200":
              description: OK
              content:
                application/json:
                  schema:
                    $ref: '#/components/schemas/Orange'
    components:
      schemas:
        Orange:
          type: object
          properties:
            id:
              type: string
            name:
              type: string

 *
 */
class GenericWithUpperBoundTest {
    static class OrangeDto {
        public String id;
    }

    static class Orange extends OrangeDto {
        public String name;
    }

    static class BaseResource<T extends OrangeDto> {
        @GET
        public T test() {
            return null;
        }
    }

    @Path("/generic-with-upper-bound")
    static class TestResource extends BaseResource<Orange> {
        public TestResource() {
        }
    }
}

