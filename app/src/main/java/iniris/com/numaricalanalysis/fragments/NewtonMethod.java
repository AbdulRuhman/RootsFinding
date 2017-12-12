package iniris.com.numaricalanalysis.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import iniris.com.numaricalanalysis.R;
import iniris.com.numaricalanalysis.calculations.Newton;

import com.google.android.gms.plus.PlusOneButton;

/**
 * A fragment with a Google +1 button.
 */
import java.util.ArrayList;

public class NewtonMethod extends Fragment {
    String result="";
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    private PlusOneButton mPlusOneButton;
    TextView txt_result;
    EditText txt_fx,txt_dx,txt_point;
    double temp1=0,temp2=0;
    Button btn_calc;
    public NewtonMethod() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);
        txt_result= (TextView) view.findViewById(R.id.textResult);
        btn_calc=(Button)view.findViewById(R.id.btnCalc);
        txt_dx=(EditText) view.findViewById(R.id.txtdx);
        txt_fx=(EditText) view.findViewById(R.id.txtfx);
        txt_point=(EditText) view.findViewById(R.id.txtpoint);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Editable point=txt_point.getText();
                    Editable fx=txt_fx.getText();
                    Editable dx=txt_dx.getText();
                    temp1=Double.parseDouble(point.toString().trim());

                    //double x =Newton.Calculate("+1cos(+1x^+1)-1x^+1","-1sin(+1x^+1)-1x^+0",Math.PI/4);
                   double x =Newton.Calculate(fx.toString(),dx.toString(),temp1);
                    temp1=x;
                    txt_point.setText(temp1+"");
                   result+=x+"\n";
                    txt_result.setText(result);

                }catch (Exception e ){
                    txt_result.setText(e.getMessage());
                    e.printStackTrace();
                }

            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
    }


}
