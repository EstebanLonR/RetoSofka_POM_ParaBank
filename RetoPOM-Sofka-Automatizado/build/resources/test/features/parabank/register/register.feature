# new feature
# Tags: optional

Feature:Registro ParaBank
  Yo como usuario
  Necesito registrarme en la pagina de ParaBank
  Para acceder a todas sus funcionalidades web

  @SuccesfullyRegister
  Scenario: Registro exitoso con todos los campos obligatorios
    Given que el usuario se encuentra en la pagina principal
    When el usuario se dirige al apartado de registro y diligencia todos los campos del formulario y envia su informacion
      | firstName | lastName | address          | city     | state    | zipCode  | socialSecurityNumber | userName   | password | confirmPassword |
      | Bartolo   | Incapie  | Calle 48A #58-60 | Carballo | Colorado | 50001266 | 0000001              | Jinjonatar | 123456   | 123456          |
    Then el sistema deberia de mostrarle un mensaje de bienvenida

  @InvalidRegister
  Scenario: Registro fallido con credenciales ya registradas.
    Given que el usuario se encuentra en la pagina principal
    When el usuario se dirige al apartado de registro y diligencia todos los campos del formulario con datos ya registrados
      | firstName | lastName | address          | city     | state    | zipCode  | socialSecurityNumber | userName   | password | confirmPassword |
      | Bartolo   | Incapie  | Calle 48A #58-60 | Carballo | Colorado | 50001266 | 0000001              | Jinjonatar | 123456   | 123456          |
    Then el sistema debera mostrarle un mensaje de que el username ya se encuentra previamente registrado