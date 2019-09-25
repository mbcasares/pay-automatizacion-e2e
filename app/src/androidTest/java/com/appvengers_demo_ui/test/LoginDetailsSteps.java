package com.appvengers_demo_ui.test;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;

import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Y;
import cucumber.api.java.es.Entonces;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@CucumberOptions(features="features", glue = "com.cucumber.demo.test")
public class LoginDetailsSteps {

    private UiDevice mDevice;
    private UiObject txtUsername;
    private UiObject txtPassword;
    private UiObject btnLogin;
    private UiObject lblAlertaIncorrecto;
    private UiObject lblMensajeBienvenida;
    private UiObject btnCerrar;

    @Dado("^Inicio el app$")
    public void inicioElApp() throws UiObjectNotFoundException {
    // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Mi Vecino Pagos"));
        allAppsButton.clickAndWaitForNewWindow();
    }

    @Cuando("^Doy clic en el campo de usuario$")
    public void doyClicEnElCampoDeUsuario() {
        txtUsername = mDevice.findObject(new UiSelector().className("android.widget.EditText").text("Usuario"));
    }

    @Y("^Ingreso un usuario \"([^\"]*)\"$")
    public void ingresoUnUsuario(String usuario) throws UiObjectNotFoundException {
        txtUsername.setText(usuario);
    }

    @Y("^Espero unos segundos$")
    public void esperoUnosSegundos() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Y("^Doy clic en el campo de password$")
    public void doyClicEnElCampoDePassword() {
        txtPassword = mDevice.findObject(new UiSelector().className("android.widget.EditText").text("Contraseña"));
    }

    @Y("^Ingreso un password \"([^\"]*)\"$")
    public void ingresoUnPassword(String password) throws UiObjectNotFoundException {
        txtPassword.setText(password);
    }

    @Y("^Doy clic en el boton Continuar$")
    public void doyClicEnElBotonContinuar() throws UiObjectNotFoundException {
        btnLogin = mDevice.findObject(new UiSelector().className("android.widget.TextView").text("Continuar"));
        btnLogin.clickAndWaitForNewWindow();
    }


    @Entonces("^Espero ver la pantalla de Acceso Incorrecto$")
    public void esperoVerLaPantallaDeAccesoIncorrecto() throws UiObjectNotFoundException, InterruptedException {

        lblAlertaIncorrecto = mDevice.findObject(new UiSelector().className("android.widget.TextView").text("Acceso incorrecto"));
        if(lblAlertaIncorrecto.getText().equalsIgnoreCase("Acceso incorrecto")){
            btnCerrar=mDevice.findObject(new UiSelector().className("android.widget.TextView").index(0));
            Thread.sleep(2000);
            btnCerrar.clickAndWaitForNewWindow();
            mDevice.pressBack();
        }
    }

}
