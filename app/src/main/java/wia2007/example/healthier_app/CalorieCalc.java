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
    TableRow tbladd;
    Button calculate, add, edit;
    Spinner spinner;
    String[] mealsperday = {"3", "4"};
    int qty, calinput;
    String bfd, lfd, dfd, bcl, lcl, dcl, mfd, mcl;

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
        brecal = view.findViewById(R.id.brcal);
        luncal = view.findViewById(R.id.lucal);
        dincal = view.findViewById(R.id.dical);
        calo = view.findViewById(R.id.Calories);
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
                            perclr.setText(String.format(" /%d kcal", clr));
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
                Toast.makeText(requireContext(), "Morning snack row added", Toast.LENGTH_SHORT).show();
                tbladd = new TableRow(getContext());
                etms = new TextView(getContext());
                etsnack = new EditText(getContext());
                etmscal = new EditText(getContext());
                //etms
                etms.setTextSize(12);
                etms.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                etms.setText("Morning snack");
                etms.setGravity(Gravity.CENTER);
                etms.setBackgroundResource(R.drawable.cell_shape);
                etms.setPadding(6, 18, 6, 18);
                etms.setTextColor(Color.rgb(0, 25, 255));
                //etsnack
                etsnack.setTextSize(12);
                etsnack.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT, 2f));
                etsnack.setText("Foods");
                etsnack.setGravity(Gravity.CENTER);
                etsnack.setBackgroundResource(R.drawable.cell_shape);
                etsnack.setPadding(6, 18, 6, 18);
                etsnack.setTextColor(Color.rgb(0, 25, 255));
                //etmscal
                etmscal.setTextSize(12);
                etmscal.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                etmscal.setText("0 kcal");
                etmscal.setGravity(Gravity.CENTER);
                etmscal.setBackgroundResource(R.drawable.cell_shape);
                etmscal.setPadding(6, 18, 6, 18);
                etmscal.setTextColor(Color.rgb(0, 25, 255));
                tbladd.addView(etms);
                tbladd.addView(etsnack);
                tbladd.addView(etmscal);
                tbleat.addView(tbladd);
            }
        });

        SharedPreferences calprefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        int calinput1 = calprefs.getInt("calories", calinput);
        calo.setText("" + calinput1);

        String bfdd = calprefs.getString("bfd", "");
        if (brefoods != null) {
            brefoods.setText("" + bfdd);
        }
        String lfdd = calprefs.getString("lfd", "");
        if (lunfoods != null) {
            lunfoods.setText("" + lfdd);
        }
        String dfdd = calprefs.getString("dfd", "");
        if (dinfoods != null) {
            dinfoods.setText("" + dfdd);
        }
        String bcll = calprefs.getString("bcl", "");
        if (brecal != null) {
            brecal.setText("" + bcll);
        }
        String lcll = calprefs.getString("lcl", "");
        if (luncal != null) {
            luncal.setText("" + lcll);
        }
        String dcll = calprefs.getString("dcl", "");
        if (dincal != null) {
            dincal.setText("" + dcll);
        }
        String mfdd = calprefs.getString("mfd", mfd);
        if (etsnack != null) {
            etsnack.setText("" + mfdd);
        }
        String mcll = calprefs.getString("mcl", mcl);
        if (etmscal != null) {
            etmscal.setText("" + mcll);
        }

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Saved successfully", Toast.LENGTH_SHORT).show();
                String input = calo.getText().toString();
                bfd = brefoods.getText().toString();
                lfd = lunfoods.getText().toString();
                dfd = dinfoods.getText().toString();
                bcl = brecal.getText().toString();
                lcl = luncal.getText().toString();
                dcl = dincal.getText().toString();
                if (etsnack != null) {
                    mfd = etsnack.getText().toString();
                }
                if (etmscal != null) {
                    mcl = etmscal.getText().toString();
                }
                calinput = Integer.parseInt(input);

                SharedPreferences precal = PreferenceManager.getDefaultSharedPreferences(requireContext());
                SharedPreferences.Editor edtcal = precal.edit();

                edtcal.putInt("calories", calinput);
                edtcal.putString("bfd", bfd);
                edtcal.putString("lfd", lfd);
                edtcal.putString("dfd", dfd);
                edtcal.putString("bcl", bcl);
                edtcal.putString("lcl", lcl);
                edtcal.putString("dcl", dcl);
                //check
                edtcal.putString("mfd", mfd);
                edtcal.putString("mcl", mcl);
                edtcal.apply();

                String brcl = brecal.getText().toString();
                brcl = brcl.replaceAll("[^\\d]", "");
                Integer brclnum = 0;
                if (!brcl.trim().isEmpty()) {
                    brclnum = Integer.parseInt(brcl);
                } else {
                    brcl = "0 kcal";
                    Toast.makeText(requireContext(), "Please enter again", Toast.LENGTH_SHORT).show();
                }

                String lucl = luncal.getText().toString();
                lucl = lucl.replaceAll("[^\\d]", "");
                Integer luclnum = Integer.parseInt(lucl);

                String dicl = dincal.getText().toString();
                dicl = dicl.replaceAll("[^\\d]", "");
                Integer diclnum = Integer.parseInt(dicl);
                Integer totclr = diclnum + brclnum + luclnum;

                if (etmscal != null) {
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