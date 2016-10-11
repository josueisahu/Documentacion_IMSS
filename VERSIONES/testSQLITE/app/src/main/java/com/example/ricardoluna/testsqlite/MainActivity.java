package com.example.ricardoluna.testsqlite;

import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMostrar =(Button) findViewById(R.id.btnMostrar);
        Button btnInsertar =(Button) findViewById(R.id.btnInsertar);
        Button btnBorrar =(Button) findViewById(R.id.btnBorrar);
     //   final EditText txtSerie = (EditText) getActivity().findViewById(R.id.txtSerie);
        final DBHandler dbH =new DBHandler(this);
        /*btnCrear.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                // Perform action on click

               // dbH.readUsuarios();
                Log.e("BASE DATOS","CREAAAAADAAA");

                }
            });


*/
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            //@TargetApi(Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                // Perform action on click
                dbH.BorrarTodo();
                //dbH.insertaUsuario(new Usuario("111","123","Ricardo"));
            }
        });

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SincronizaServerToLocalBD asyncT = new SincronizaServerToLocalBD();
                asyncT.execute();
            }
            //@TargetApi(Build.VERSION_CODES.KITKAT)



               // dbH.inserta();
                 //dbH.insertaUsuario(new Usuario("111","123","Ricardo"));
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Usuario> usuarios = dbH.obtenerTodosUsuarios();
                String log = "\n";
               // Log.e("TO STRING.:.",usuarios.toString());
                for(Usuario usuario:usuarios)
                {
                   /* log = log
                            + "Login: " + usuario.getLogin()
                            + " Password: " + usuario.getPassword()
                            + " Nombre: " + usuario.getNombre()
                            + "\n";
                    */
                   // Log.i("Login: " , usuario.getLogin());
                   // Log.i(" Password: " , usuario.getPassword());
                   // Log.i(" Nombre: " , usuario.getNombre());
                   // Log.e("USUARIO :::", log);
                }
                //Log.e("USUARIO :::", log);
            }
        });

    }
    /* Inner class to get response */
    class SincronizaServerToLocalBD extends AsyncTask<Void, Void, Void> {
        DBHandler db= new DBHandler(getApplicationContext().getApplicationContext());
        String Datos,  resp;
        TextView lblResul;
        String Cad="si entra";
        SincronizaServerToLocalBD()
        {

        }

        @Override
        //protected Void doInBackground(Void... voids) {
        protected Void doInBackground(Void... voids) {
            Log.e("siisisi","sisisi");
            // HttpPost httpPost = new HttpPost("http://192.168.43.33/WS/sincronizaServerToLocalBD.php");
            HttpPost httpPost = new HttpPost("http://192.168.43.33/WS/select.php");
            //TextView textView = (TextView)findViewById(R.id.txtMessage);
            //TextView textView = (TextView)findViewById(R.id.txtMessage);
           HttpClient httpclient = new DefaultHttpClient();
          //  System.gc();
            try
            {
               HttpResponse response = httpclient.execute(httpPost);

                String jsonResult = inputStreamToString(response.getEntity().getContent()).toString();

                ////////////////OBTIENE JSON ////////////////////////////////////
                JSONArray jArray = new JSONArray(jsonResult);

                JSONObject jObject = new JSONObject(String.valueOf(jArray.getJSONObject(0)));

                /////////////SEPARA EL JSON EN CADA TABLA E INSERTA///////////////
                JSONArray Datos = jObject.getJSONArray("Usuarios");
                JSONObject Object;

                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                        // Pulling items from the array
                        String Login = Object.getString("Login");
                        String Password = Object.getString("Password");
                        String nombre  = URLDecoder.decode(Object.getString("nombre"),"UTF-8");
                    Log.i("VALOR", ""+i);
                        Log.i("LOGIN: ", Login);
                }


                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(1)));
                Datos = jObject.getJSONArray("Unidades");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                        // Pulling items from the array
                        String NumeroUnidad = Object.getString("NumeroUnidad");
                        String Encargado = URLDecoder.decode(Object.getString("Encargado"),"UTF-8");
                    Log.i("VALOR", ""+i);
                        Log.i("NumUnid: ", NumeroUnidad);
                        Log.i("Encargado: ", Encargado);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(2)));
                Datos = jObject.getJSONArray("Areas");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array
                        String CodDepartamento = Object.getString("CodDepartamento");
                        String Descripcion = URLDecoder.decode(Object.getString("Descripcion"),"UTF-8");
                    Log.i("VALOR", ""+i);
                        Log.i("CodDepartamento: ", CodDepartamento);
                        Log.i("Descripcion: ", Descripcion);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(3)));
                Datos = jObject.getJSONArray("Depto_Areas");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array
                        String id = Object.getString("id");
                        String idUnidad = Object.getString("idUnidad");
                        String depto = Object.getString("depto");
                        String area = URLDecoder.decode(Object.getString("area"),"UTF-8");
                    Log.i("VALOR", ""+i);
                        Log.i("id: ", id);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(4)));
                Datos = jObject.getJSONArray("detalleEquipos");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array
                    String id = Object.getString("id");
                    String serie =URLDecoder.decode(Object.getString("serie"),"UTF-8");
                    String ip = URLDecoder.decode(Object.getString("ip"),"UTF-8");
                    String macaddress = URLDecoder.decode(Object.getString("macaddress"),"UTF-8");
                    String host = URLDecoder.decode(Object.getString("host"),"UTF-8");
                    String observaciones = URLDecoder.decode(Object.getString("observaciones"),"UTF-8");
                    String extension = URLDecoder.decode(Object.getString("extension"),"UTF-8");
                    String matricula = URLDecoder.decode(Object.getString("matricula"),"UTF-8");
                    String nombre = URLDecoder.decode(Object.getString("nombre"),"UTF-8");
                    String apellidopaterno = URLDecoder.decode(Object.getString("apellidopaterno"),"UTF-8");
                    String apellidomaterno = URLDecoder.decode(Object.getString("apellidomaterno"),"UTF-8");
                    String puesto = URLDecoder.decode(Object.getString("puesto"),"UTF-8");
                    String impresora = URLDecoder.decode(Object.getString("impresora"),"UTF-8");
                    String observacionImpresora = URLDecoder.decode(Object.getString("observacionImpresora"),"UTF-8");

                    Log.i("VALOR", ""+i);
                }
                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(5)));
                Datos = jObject.getJSONArray("Marcas");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array
                    String clave = Object.getString("clave");
                    String nombre = URLDecoder.decode(Object.getString("nombre"),"UTF-8");
                    Log.i("VALOR", ""+i);
                    Log.i("clave: ", clave);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(6)));
                Datos = jObject.getJSONArray("Dispositivos");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array
                    String clave = Object.getString("clave");
                    String nombre = URLDecoder.decode(Object.getString("nombre"),"UTF-8");
                    Log.i("VALOR", ""+i);
                    Log.i("clave: ", clave);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(7)));
                Datos = jObject.getJSONArray("Modelos");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array
                    String id = Object.getString("id");
                    String nombre = URLDecoder.decode(Object.getString("nombre"),"UTF-8");
                    String idDispositivo = Object.getString("idDispositivo");
                    String idMarca = Object.getString("idMarca");
                    Log.i("VALOR", ""+i);
                    Log.i("id: ", id);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(8)));
                Datos = jObject.getJSONArray("Equipos");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array
                    String numeroSerie = URLDecoder.decode(Object.getString("numeroSerie"),"UTF-8");
                    String numeroInventario = Object.getString("numeroInventario");
                    String idModelo = Object.getString("idModelo");
                    String status = Object.getString("status");
                    Log.i("VALOR", ""+i);
                    Log.i("numeroSerie: ", numeroSerie);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(9)));
                Datos = jObject.getJSONArray("Categorias");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array
                    String id = Object.getString("id");
                    String clave = Object.getString("clave");
                    String descripcion = Object.getString("descripcion");
                    Log.i("VALOR", ""+i);
                    Log.i("id: ", id);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(10)));
                Datos = jObject.getJSONArray("Trabajadores");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array

                    String matricula = Object.getString("matricula");
                    String nombre = URLDecoder.decode(Object.getString("nombre"),"UTF-8");
                    String puesto = Object.getString("puesto"); 
                    Log.i("VALOR", ""+i);
                    Log.i("matricula: ", matricula);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(11)));
                Datos = jObject.getJSONArray("Switchers");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array

                    String id = Object.getString("id");
                    String mdf = Object.getString("mdf");
                    String numMdf = Object.getString("numMdf");
                    String rack = Object.getString("rack");
                    String numRack = Object.getString("numRack");

                    Log.i("VALOR", ""+i);
                    Log.i("id: ", id);
                    Log.i("mdf: ", mdf);
                    Log.i("numMdf: ", numMdf);
                    Log.i("rack: ", rack);
                    Log.i("numRack: ", numRack);
                }
                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(12)));
                Datos = jObject.getJSONArray("DetalleSwitcher");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array

                    String serie = Object.getString("serie");
                    String idSwitcher = Object.getString("idSwitcher");
                    String numero = Object.getString("numero");
                    String propiedad = Object.getString("propiedad");

                    Log.i("VALOR", ""+i);
                    Log.i("serie: ", serie);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(13)));
                Datos = jObject.getJSONArray("FotoConductores");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array

                    String id = Object.getString("id");
                    String descripcion = Object.getString("descripcion");
                    String rendimiento = Object.getString("rendimiento");

                    Log.i("VALOR", ""+i);
                    Log.i("id: ", id);
                }

                jObject = new JSONObject(String.valueOf(jArray.getJSONObject(14)));
                Datos = jObject.getJSONArray("ImpresorasContadores");
                for (int i=0; i < Datos.length(); i++)
                {
                    Object = Datos.getJSONObject(i);
                    // Pulling items from the array

                    String folio = Object.getString("folio");
                    String serie = Object.getString("serie");
                    String idFotoconductor = Object.getString("idFotoconductor");
                    String contador = Object.getString("contador");
                    Log.i("VALOR", ""+i);
                    Log.i("folio: ", folio);
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Log.i("ERROR 1: ", e.getMessage());

            } catch (ClientProtocolException e) {
                e.printStackTrace();
                Log.i("ERROR 2: ", e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                Log.i("ERROR 3: ", e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
           // db.close();
           // lblResul.setText("Sincronización Exitosa!");

        }


    }
    private StringBuilder inputStreamToString(InputStream is)
    {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));

        try
        {
            while ((rLine = rd.readLine()) != null)
            {
                answer.append(rLine);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return answer;
    }
/*
    private void bulkInsertOneHundredRecords() {
        String sql = "INSERT INTO "+ SAMPLE_TABLE_NAME +" VALUES (?,?,?);";
        SQLiteStatement statement = sampleDB.compileStatement(sql);
        sampleDB.beginTransaction();
        for (int i = 0; i<100; i++) {
            statement.clearBindings();
            statement.bindLong(1, i);
            statement.bindLong(2, i);
            statement.bindLong(3, i*i);
            statement.execute();
        }
        sampleDB.setTransactionSuccessful();
        sampleDB.endTransaction();
    }
    */
}
