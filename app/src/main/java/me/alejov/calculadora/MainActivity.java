package me.alejov.calculadora;
import java.lang.Math;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText _edit;
    private Button _b1;
    private Button _b2;
    private Button _b3;
    private Button _b4;
    private Button _b5;
    private Button _b6;
    private Button _b7;
    private Button _b8;
    private Button _b9;
    private Button _b0;
    private Button _bMas;
    private Button _bMenos;
    private Button _bMultiplicar;
    private Button _bDividir;
    private Button _bIgual;
    private Button _buttonC;
    private Button _buttonCOS;
    private Button _buttonSEN;
    private Button _buttonTAN;
    private Button _buttonLOG;

    private int _valor;
    private double _valorfunciones;

    private int _operacion;


    private boolean _nuevoValor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _valor = 0;
       _valorfunciones =0;
        _edit = (EditText) findViewById(R.id.editText);
        _b0 = (Button) findViewById(R.id.button0);
        _b1 = (Button) findViewById(R.id.button1);
        _b2 = (Button) findViewById(R.id.button2);
        _b3 = (Button) findViewById(R.id.button3);
        _b4 = (Button) findViewById(R.id.button4);
        _b5 = (Button) findViewById(R.id.button5);
        _b6 = (Button) findViewById(R.id.button6);
        _b7 = (Button) findViewById(R.id.button7);
        _b8 = (Button) findViewById(R.id.button8);
        _b9 = (Button) findViewById(R.id.button9);
        _bMas = (Button) findViewById(R.id.Mas);
        _bMenos = (Button) findViewById(R.id.Menos);
        _bMultiplicar = (Button) findViewById(R.id.Multiplicar);
        _bDividir = (Button) findViewById(R.id.Dividir);
        _bIgual = (Button) findViewById(R.id.igual);
        _buttonC = (Button) findViewById(R.id.buttonC);
        _buttonCOS = (Button) findViewById(R.id.buttonCos);
        _buttonSEN = (Button) findViewById(R.id.buttonSen);
        _buttonTAN = (Button) findViewById(R.id.buttonTan);
        _buttonLOG = (Button) findViewById(R.id.buttonLOG);

        _edit.setText("0");

        View.OnClickListener lsBoton = new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                _edit.setTextColor(Color.BLACK);
                cambiaValor();
                _edit.setText(_edit.getText() + ((Button) arg0).getText().toString());
            }
        };

        View.OnClickListener lsBotonOperacion = new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                opera();
                _operacion = 0;
                _nuevoValor = true;
                String text = ((Button) arg0).getText().toString();
                if (text.equals("+")) _operacion = 0;
                if (text.equals("-")) _operacion = 1;
                if (text.equals("*")) _operacion = 2;
                if (text.equals("/")) _operacion = 3;
                if (text.equals("=")) _operacion = -1;
                if (text.equals("SEN")) _operacion = 4;
                if (text.equals("Cos")) _operacion = 5;
                if (text.equals("TAN")) _operacion = 6;
                if (text.equals("LOG")) _operacion = 7;

            }
        };

        _b1.setOnClickListener(lsBoton);
        _b2.setOnClickListener(lsBoton);
        _b3.setOnClickListener(lsBoton);
        _b4.setOnClickListener(lsBoton);
        _b5.setOnClickListener(lsBoton);
        _b6.setOnClickListener(lsBoton);
        _b7.setOnClickListener(lsBoton);
        _b8.setOnClickListener(lsBoton);
        _b9.setOnClickListener(lsBoton);
        _b0.setOnClickListener(lsBoton);

        _bMas.setOnClickListener(lsBotonOperacion);
        _bMenos.setOnClickListener(lsBotonOperacion);
        _bMultiplicar.setOnClickListener(lsBotonOperacion);
        _bDividir.setOnClickListener(lsBotonOperacion);
        _bIgual.setOnClickListener(lsBotonOperacion);
        _buttonCOS.setOnClickListener(lsBotonOperacion);
        _buttonSEN.setOnClickListener(lsBotonOperacion);
        _buttonTAN.setOnClickListener(lsBotonOperacion);
        _buttonLOG.setOnClickListener(lsBotonOperacion);
        _buttonC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                _edit.setText("0");
                _nuevoValor = true;
                _operacion = -1;
            }
        });

    }

    private void cambiaValor() {
        if (_nuevoValor == true) {
            _edit.setText("");
            _nuevoValor = false;
        }
    }

    private void opera() {
        switch (_operacion) {
            case -1:
                _valor = Integer.parseInt(_edit.getText().toString());
                break;
            case 0:    // suma
                try {
                    _valor = _valor + Integer.parseInt(_edit.getText().toString());
                    _edit.setText(String.valueOf(_valor));
                } catch (Exception e) {

                }
                break;

            case 1:    // resta
                try {
                    _valor = _valor - Integer.parseInt(_edit.getText().toString());
                    _edit.setText(String.valueOf(_valor));
                } catch (Exception e) {

                }
                break;
            case 2:    // multiplicar
                try {
                    _valor = _valor * Integer.parseInt(_edit.getText().toString());
                    _edit.setText(String.valueOf(_valor));
                } catch (Exception e) {

                }
                break;
            //

            case 3:    // dividir
                try {
                    _valor = _valor / Integer.parseInt(_edit.getText().toString());
                    _edit.setText(String.valueOf(_valor));
                } catch (Exception e) {
                    _edit.setTextColor(Color.BLUE);
                    _edit.setText("Err");
                }
                break;
            //
            case 4:    // seno
                try {
                    _valorfunciones = Math.sin(Math.toRadians(Double.parseDouble(_edit.getText().toString())));
                    _edit.setText(String.valueOf(_valorfunciones));
                } catch (Exception e) {
                    _edit.setTextColor(Color.BLUE);
                    _edit.setText("Err");
                }
                break;
            //
            case 5:    // coseno
                try {
                    _valorfunciones = Math.cos(Math.toRadians(Double.parseDouble(_edit.getText().toString())));
                    _edit.setText(String.valueOf(_valorfunciones));
                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.BLUE);
                    _edit.setText("Err");
                }
                break;
            case 6:    // tangente
                try {
                    _valorfunciones = Math.tan(Math.toRadians(Double.parseDouble(_edit.getText().toString())));
                    _edit.setText(String.valueOf(_valorfunciones));
                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.BLUE);
                    _edit.setText("Err");
                }
                break;
            case 7:    // LOGARITMO
                try {
                    _valorfunciones = Math.log(Double.parseDouble(_edit.getText().toString()));
                    _edit.setText(String.valueOf(_valorfunciones));
                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.BLUE);
                    _edit.setText("Err");
                }
                break;

        }
    }


}

