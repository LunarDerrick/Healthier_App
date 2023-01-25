package wia2007.example.healthier_app;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class CalorieCalc extends Fragment {

    EditText calo, etsnack, etmscal, brefoods, lunfoods, dinfoods, brecal, luncal, dincal;
    TextView brkfst, mngsnk, lnch, dnr, brminmax, msminmax, lcminmax, dnminmax, perclr, etms, totcal, tvrec;
    CardView cvrec;
    TableLayout tbleat;
    TableRow tbladd, tblms;
    Button calculate, add, edit;
    Spinner spinner;
    String[] mealsperday = {"3", "4"};
    int qty, calinput;
    String bfast, lunch, dnnr, bfastcal, lunchcal, dnnrcal, snack, snackcal, totalcalorie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calorie, container, false);

        calculate = view.findViewById(R.id.calcButton);
        add = view.findViewById(R.id.BTPlus);
        edit = view.findViewById(R.id.BTEditEat);
        tbleat = view.findViewById(R.id.TBLEaten);
        mngsnk = view.findViewById(R.id.TVMornSnack);
        lnch = view.findViewById(R.id.TVLunch);
        dnr = view.findViewById(R.id.TVDinner);
        brkfst = view.findViewById(R.id.TVBreakfast);
        brminmax = view.findViewById(R.id.TVBMinMax);
        msminmax = view.findViewById(R.id.TVMSMinMax);
        lcminmax = view.findViewById(R.id.TVLMinMax);
        dnminmax = view.findViewById(R.id.TVDMinMax);
        totcal = view.findViewById(R.id.TVTarget);
        tvrec = view.findViewById(R.id.TVRecommend);
        cvrec = view.findViewById(R.id.CVRecommend);
        perclr = view.findViewById(R.id.percalories);
        brefoods = view.findViewById(R.id.brfoods);
        lunfoods = view.findViewById(R.id.lufoods);
        dinfoods = view.findViewById(R.id.difoods);
        etsnack = view.findViewById(R.id.msfoods);
        brecal = view.findViewById(R.id.brcal);
        luncal = view.findViewById(R.id.lucal);
        dincal = view.findViewById(R.id.dical);
        etmscal = view.findViewById(R.id.mscal);
        calo = view.findViewById(R.id.Calories);
        tblms = view.findViewById(R.id.TBRMs);
        spinner = view.findViewById(R.id.mealsperday);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, mealsperday);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                qty = Integer.parseInt(selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setSelection(0);
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = calo.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(requireContext(), R.string.toastError, Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        calinput = Integer.parseInt(input);
                        if (calinput <= 0) {
                            Toast.makeText(requireContext(), R.string.toastError, Toast.LENGTH_SHORT).show();
                        } else {
                            Integer clr = Integer.parseInt(calo.getText().toString());
                            //perclr.setText(String.format(" /%d kcal", clr));
                            if (qty == 3) {
                                Double dmin = clr * 0.25;
                                Double dn = clr * 0.3;
                                Double bmin = clr * 0.3;
                                Double bkf = clr * 0.325;
                                Double bmax = clr * 0.35;
                                Double lmin = clr * 0.35;
                                Double dmax = clr * 0.35;
                                Double lc = clr * 0.375;
                                Double lmax = clr * 0.4;
                                brkfst.setText(String.format("Breakfast\t\t\t\t\t\t%.0f kcal", bkf));
                                mngsnk.setText("Morning snack\t\t\t\t\t 0 kcal");
                                lnch.setText(String.format("Lunch\t\t\t\t\t\t%.0f kcal", lc));
                                dnr.setText(String.format("Dinner\t\t\t\t\t\t%.0f kcal", dn));
                                brminmax.setText(String.format("(min: %.0f, max: %.0f)", bmin, bmax));
                                msminmax.setText("(min: 0, max: 0)");
                                lcminmax.setText(String.format("(min: %.0f, max: %.0f)", lmin, lmax));
                                dnminmax.setText(String.format("(min: %.0f, max: %.0f)", dmin, dmax));
                                tblms.setVisibility(View.GONE);
                                Toast.makeText(requireContext(), "Only 3 meals today!", Toast.LENGTH_SHORT).show();
                            } else if (qty == 4) {
                                Double msmin = clr * 0.05;
                                Double mgsk = clr * 0.075;
                                Double msmax = clr * 0.1;
                                Double bmin = clr * 0.25;
                                Double dmin = clr * 0.25;
                                Double bkf = clr * 0.275;
                                Double dn = clr * 0.275;
                                Double bmax = clr * 0.3;
                                Double dmax = clr * 0.3;
                                Double lmin = clr * 0.35;
                                Double lc = clr * 0.375;
                                Double lmax = clr * 0.4;
                                brkfst.setText(String.format("Breakfast\t\t\t\t\t\t%.0f kcal", bkf));
                                mngsnk.setText(String.format("Morning snack\t\t\t\t\t%.0f kcal", mgsk));
                                lnch.setText(String.format("Lunch\t\t\t\t\t\t%.0f kcal", lc));
                                dnr.setText(String.format("Dinner\t\t\t\t\t\t%.0f kcal", dn));
                                brminmax.setText(String.format("(min: %.0f, max: %.0f)", bmin, bmax));
                                msminmax.setText(String.format("(min: %.0f, max: %.0f)", msmin, msmax));
                                lcminmax.setText(String.format("(min: %.0f, max: %.0f)", lmin, lmax));
                                dnminmax.setText(String.format("(min: %.0f, max: %.0f)", dmin, dmax));
                                tblms.setVisibility(View.VISIBLE);
                                Toast.makeText(requireContext(), "Snack morning row added", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(requireContext(), R.string.toastError, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qty == 3){
                    Toast.makeText(requireContext(), "Only 3 meals today!", Toast.LENGTH_SHORT).show();
                }else if(qty == 4){
                    Toast.makeText(requireContext(), "Only 4 meals today!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        SharedPreferences calprefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        int calinput1 = calprefs.getInt("calories", calinput);
        calo.setText("" + calinput1);

        String bfd = calprefs.getString("breakfast", "");
        brefoods.setText("" + bfd);

        String lfd = calprefs.getString("lunch", "");
        lunfoods.setText("" + lfd);

        String dfd = calprefs.getString("dinner", "");
        dinfoods.setText("" + dfd);

        String bcl = calprefs.getString("breakfastcalorie", "0 kcal");
        brecal.setText("" + bcl);

        String lcl = calprefs.getString("lunchcalorie", "0 kcal");
        luncal.setText("" + lcl);

        String dcl = calprefs.getString("dinnercalorie", "0 kcal");
        dincal.setText("" + dcl);

        //final String[] mpd = {calprefs.getString("mealsperday", "")};


        String mfd = calprefs.getString("snack", "");
        if (etsnack != null) {
            etsnack.setText("" + mfd);
        }

        String mcl = calprefs.getString("snackcalorie", "0 kcal");
        if (etmscal != null) {
            etmscal.setText("" + mcl);
        }

        String percalo = calprefs.getString("perclr", "/0 kcal");
        perclr.setText(percalo);

        String totcalo = calprefs.getString("totalcalorie", "0");
        totcal.setText(totcalo);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Saved successfully", Toast.LENGTH_SHORT).show();
                String input = calo.getText().toString();
                bfast = brefoods.getText().toString();
                lunch = lunfoods.getText().toString();
                dnnr = dinfoods.getText().toString();
                bfastcal = brecal.getText().toString();
                lunchcal = luncal.getText().toString();
                dnnrcal = dincal.getText().toString();
                snack = etsnack.getText().toString();
                snackcal = etmscal.getText().toString();
                totalcalorie = totcal.getText().toString();
                //mpd[0] = spinner.getSelectedItem().toString();

                calinput = Integer.parseInt(input);
                perclr.setText("/" + calinput + " kcal");

                SharedPreferences precal = PreferenceManager.getDefaultSharedPreferences(requireContext());
                SharedPreferences.Editor edtcal = precal.edit();

                edtcal.putInt("calories", calinput);
                //edtcal.putString("mealsperday", mpd[0]);
                edtcal.putString("breakfast", bfast);
                edtcal.putString("lunch", lunch);
                edtcal.putString("dinner", dnnr);
                edtcal.putString("breakfastcalorie", bfastcal);
                edtcal.putString("lunchcalorie", lunchcal);
                edtcal.putString("dinnercalorie", dnnrcal);
                edtcal.putString("snack", snack);
                edtcal.putString("snackcalorie", snackcal);
                edtcal.putString("perclr", perclr.getText().toString());
                edtcal.putString("totalcalorie", totcal.getText().toString());
                edtcal.apply();

                String brcl = brecal.getText().toString();
                brcl = brcl.replaceAll("[^\\d]", "");
                Integer brclnum = Integer.parseInt(brcl);

                String lucl = luncal.getText().toString();
                lucl = lucl.replaceAll("[^\\d]", "");
                Integer luclnum = Integer.parseInt(lucl);

                String dicl = dincal.getText().toString();
                dicl = dicl.replaceAll("[^\\d]", "");
                Integer diclnum = Integer.parseInt(dicl);

                Integer totclr = diclnum + brclnum + luclnum;

                if (qty == 4) {
                    String mscal = etmscal.getText().toString();
                    mscal = mscal.replaceAll("[^\\d]", "");
                    Integer mscalnum = Integer.parseInt(mscal);
                    totclr = totclr + mscalnum;
                }

                totcal.setText(String.format("%d", totclr));

            }
        });

        return view;
    }
}