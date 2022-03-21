# new feature
# Tags: optional

Feature: Atencion al cliente ParaBank
  Yo como usuario
  Necesito contactar con ParaBank
  Para poder resolver mis inquietudes acerca de sus servicios

  @ConsultaExitosa
  Scenario: Realizar consulta exitosa
    Given que el usuario se encuentra en la home page del aplicativo
    When Se dirige al apartado de atencion y diligencia el formulario con su consulta
      | name      | email                       | phone      | message                                                                                     |
      | Bartolito | capitao-whatsapp@correo.com | 3004005000 | Quisiera consultar sobre los beneficions que se podrian obtener..bla bla...Espero Respuesta |
    Then el sistema deberia de mostrarle un mensaje A Customer Care Representative will be contacting you.

  @IncorrectConsult
  Scenario:Realizar consulta sin email
    Given que el usuario se encuentra en la home page del aplicativo
    When Se dirige al apartado de atencion y diligencia el formulario sin un correo electronico
      | name             | phone      | message                                                              |
      | Chiguiro Benitez | 1561554443 | Necesito consultar....bla bla bla...  PD:No tengo correo electronico |
    Then el sistema deberia de mostrarle un mensaje de error Email is required