package wia2007.example.healthier_app;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Trainer1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Trainer1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView TVLessonBooking;
    Calendar calendar = Calendar.getInstance();

    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener dateSetListener;

    public Trainer1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Trainer1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Trainer1Fragment newInstance(String param1, String param2) {
        Trainer1Fragment fragment = new Trainer1Fragment();
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
        View view = inflater.inflate(R.layout.fragment_trainer1, container, false);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        Button BTBookLesson = (Button) view.findViewById(R.id.BTBookLessons);
        TextView TVReservation = (TextView) view.findViewById(R.id.TVReservation);

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                DateFormat fmtDate = DateFormat.getDateInstance();

                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);

                TVReservation.setText("Your lesson is set on " + fmtDate.format(calendar.getTime()));
            }
        };

        BTBookLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentYear, currentMonth, currentDayOfMonth;

                currentYear = calendar.get(Calendar.YEAR);
                currentMonth = calendar.get(Calendar.MONTH);
                currentDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(getActivity(), dateSetListener, currentYear,currentMonth,currentDayOfMonth);
                datePickerDialog.show();
            }
        });
    }
}