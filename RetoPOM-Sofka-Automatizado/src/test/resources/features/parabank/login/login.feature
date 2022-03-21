# new feature
# Tags: optional

Feature: Login ParaBank
  Yo como usuario del sistema
  Necesito poder ingresar con mis credenciales al sitio web
  Para poder realizar mis funcionalidades bancarias


  @SuccesfullyLogin
  Scenario: Login Exitoso
    Given que el usuario se encuentra en la pagina principal del portal
    When se dirige al apartado de login e ingresa sus credenciales
      | username | password |
      | Barto    | 123456   |
    Then el sistema deberia llevarlo al apartado de su resumen de cuentas

  @ForgotLoginInfo
  Scenario: Recordar Informacion Login
    Given que el usuario se encuentra en la pagina principal del portal
    When se dirige al apartado de forgot login info y diligencia el formulario
      | firstname | lastname | address          | city     | state    | zipcode  | ssn     |
      | Bartolo   | Martinez | Calle 48A #58-60 | Carballo | Colorado | 50001266 | 0000001 |
    Then el sistema deberia mostrar el mensaje de que sus credenciales fueron encontradas


