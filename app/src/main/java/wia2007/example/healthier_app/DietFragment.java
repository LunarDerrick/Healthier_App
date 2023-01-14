package wia2007.example.healthier_app;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DietFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DietFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public DietFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DietFragment.
     */
    public static DietFragment newInstance(String param1, String param2) {
        DietFragment fragment = new DietFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diet, container, false);

        final LayoutInflater[] inflater1 = {inflater};
        Button BtnComplete = view.findViewById(R.id.BtnComplete);
        Button BtnReset = view.findViewById(R.id.BtnReset);
        Button BtnEdit = view.findViewById(R.id.BTEditPlan);
        Button BtnDone = view.findViewById(R.id.BtnDone);
        TableLayout TLWeekly = view.findViewById(R.id.TLWeekly);
        TableLayout ETTLWeekly = view.findViewById(R.id.ETTLWeekly);
        TextView TVStatus = view.findViewById(R.id.TVStatus);
        // TableLayout TextView values
        TextView TVTable2BFDayM = view.findViewById(R.id.TVTable2BFDayM);
        TextView TVTable2LDayM = view.findViewById(R.id.TVTable2LDayM);
        TextView TVTable2DDayM = view.findViewById(R.id.TVTable2DDayM);
        TextView TVTable2BFDayT = view.findViewById(R.id.TVTable2BFDayT);
        TextView TVTable2LDayT = view.findViewById(R.id.TVTable2LDayT);
        TextView TVTable2DDayT = view.findViewById(R.id.TVTable2DDayT);
        TextView TVTable2BFDayW = view.findViewById(R.id.TVTable2BFDayW);
        TextView TVTable2LDayW = view.findViewById(R.id.TVTable2LDayW);
        TextView TVTable2DDayW = view.findViewById(R.id.TVTable2DDayW);
        TextView TVTable2BFDayTh = view.findViewById(R.id.TVTable2BFDayTh);
        TextView TVTable2LDayTh = view.findViewById(R.id.TVTable2LDayTh);
        TextView TVTable2DDayTh = view.findViewById(R.id.TVTable2DDayTh);
        TextView TVTable2BFDayF = view.findViewById(R.id.TVTable2BFDayF);
        TextView TVTable2LDayF = view.findViewById(R.id.TVTable2LDayF);
        TextView TVTable2DDayF = view.findViewById(R.id.TVTable2DDayF);
        TextView TVTable2BFDayS = view.findViewById(R.id.TVTable2BFDayS);
        TextView TVTable2LDayS = view.findViewById(R.id.TVTable2LDayS);
        TextView TVTable2DDayS = view.findViewById(R.id.TVTable2DDayS);
        TextView TVTable2BFDaySu = view.findViewById(R.id.TVTable2BFDaySu);
        TextView TVTable2LDaySu = view.findViewById(R.id.TVTable2LDaySu);
        TextView TVTable2DDaySu = view.findViewById(R.id.TVTable2DDaySu);
        // TableLayout EditText values
        EditText ETTable2BFDayM = view.findViewById(R.id.ETTable2BFDayM);
        EditText ETTable2LDayM = view.findViewById(R.id.ETTable2LDayM);
        EditText ETTable2DDayM = view.findViewById(R.id.ETTable2DDayM);
        EditText ETTable2BFDayT = view.findViewById(R.id.ETTable2BFDayT);
        EditText ETTable2LDayT = view.findViewById(R.id.ETTable2LDayT);
        EditText ETTable2DDayT = view.findViewById(R.id.ETTable2DDayT);
        EditText ETTable2BFDayW = view.findViewById(R.id.ETTable2BFDayW);
        EditText ETTable2LDayW = view.findViewById(R.id.ETTable2LDayW);
        EditText ETTable2DDayW = view.findViewById(R.id.ETTable2DDayW);
        EditText ETTable2BFDayTh = view.findViewById(R.id.ETTable2BFDayTh);
        EditText ETTable2LDayTh = view.findViewById(R.id.ETTable2LDayTh);
        EditText ETTable2DDayTh = view.findViewById(R.id.ETTable2DDayTh);
        EditText ETTable2BFDayF = view.findViewById(R.id.ETTable2BFDayF);
        EditText ETTable2LDayF = view.findViewById(R.id.ETTable2LDayF);
        EditText ETTable2DDayF = view.findViewById(R.id.ETTable2DDayF);
        EditText ETTable2BFDayS = view.findViewById(R.id.ETTable2BFDayS);
        EditText ETTable2LDayS = view.findViewById(R.id.ETTable2LDayS);
        EditText ETTable2DDayS = view.findViewById(R.id.ETTable2DDayS);
        EditText ETTable2BFDaySu = view.findViewById(R.id.ETTable2BFDaySu);
        EditText ETTable2LDaySu = view.findViewById(R.id.ETTable2LDaySu);
        EditText ETTable2DDaySu = view.findViewById(R.id.ETTable2DDaySu);

        BtnReset.setVisibility(View.GONE);
        BtnDone.setVisibility(View.GONE);
        ETTLWeekly.setVisibility(View.GONE);

        // BtnComplete
        View.OnClickListener OCLComplete = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // inflate the layout of the popup window
                inflater1[0] = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater1[0].inflate(R.layout.popup_window, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

                TVStatus.setText("Completed");
                BtnReset.setVisibility(View.VISIBLE);
                BtnComplete.setVisibility(View.GONE);
            }
        };
        BtnComplete.setOnClickListener(OCLComplete);

        // BtnReset
        View.OnClickListener OCLReset = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TVStatus.setText("Not Completed Yet");
                BtnReset.setVisibility(View.GONE);
                BtnComplete.setVisibility(View.VISIBLE);
            }
        };
        BtnReset.setOnClickListener(OCLReset);

        // BtnEdit
        View.OnClickListener OCLEdit = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BtnEdit.setVisibility(View.GONE);
                BtnDone.setVisibility(View.VISIBLE);
                ETTLWeekly.setVisibility(View.VISIBLE);
                TLWeekly.setVisibility(View.GONE);
            }
        };
        BtnEdit.setOnClickListener(OCLEdit);

        // BtnDone
        View.OnClickListener OCLDone = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BtnEdit.setVisibility(View.VISIBLE);
                BtnDone.setVisibility(View.GONE);
                ETTLWeekly.setVisibility(View.GONE);
                TLWeekly.setVisibility(View.VISIBLE);
                // saving values from edittext to textview
                TVTable2BFDayM.setText(ETTable2BFDayM.getText().toString());
                TVTable2LDayM.setText(ETTable2LDayM.getText().toString());
                TVTable2DDayM.setText(ETTable2DDayM.getText().toString());
                TVTable2BFDayT.setText(ETTable2BFDayT.getText().toString());
                TVTable2LDayT.setText(ETTable2LDayT.getText().toString());
                TVTable2DDayT.setText(ETTable2DDayT.getText().toString());
                TVTable2BFDayW.setText(ETTable2BFDayW.getText().toString());
                TVTable2LDayW.setText(ETTable2LDayW.getText().toString());
                TVTable2DDayW.setText(ETTable2DDayW.getText().toString());
                TVTable2BFDayTh.setText(ETTable2BFDayTh.getText().toString());
                TVTable2LDayTh.setText(ETTable2LDayTh.getText().toString());
                TVTable2DDayTh.setText(ETTable2DDayTh.getText().toString());
                TVTable2BFDayF.setText(ETTable2BFDayF.getText().toString());
                TVTable2LDayF.setText(ETTable2LDayF.getText().toString());
                TVTable2DDayF.setText(ETTable2DDayF.getText().toString());
                TVTable2BFDayS.setText(ETTable2BFDayS.getText().toString());
                TVTable2LDayS.setText(ETTable2LDayS.getText().toString());
                TVTable2DDayS.setText(ETTable2DDayS.getText().toString());
                TVTable2BFDaySu.setText(ETTable2BFDaySu.getText().toString());
                TVTable2LDaySu.setText(ETTable2LDaySu.getText().toString());
                TVTable2DDaySu.setText(ETTable2DDaySu.getText().toString());
            }
        };
        BtnDone.setOnClickListener(OCLDone);

        return view;
    }
}