package wia2007.example.healthier_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.function.IntToDoubleFunction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProgressTFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgressTFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GraphView graphView;
    EditText calorieTaken, calorieBurnt;
    Button submitCalories;
    TextView daily_average_result;
    int x, y;

    final String [] daysInWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public ProgressTFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProgressTFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProgressTFragment newInstance(String param1, String param2) {
        ProgressTFragment fragment = new ProgressTFragment();
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
        View view = inflater.inflate(R.layout.fragment_progress_t, container, false);

        //get days
        Format f = new SimpleDateFormat("EEEE");
        String whichDay = f.format(new Date());

        //set point x based on days
        switch (whichDay) {
            case "Monday":
                x = 1;
                break;
            case "Tuesday":
                x = 2;
                break;
            case "Wednesday":
                x = 3;
                break;
            case "Thursday":
                x = 4;
                break;
            case "Friday":
                x = 5;
                break;
            case "Saturday":
                x = 6;
                break;
            default:
                x = 7;
                break;
        }

        daily_average_result = view.findViewById(R.id.daily_average_result);

        //input burnt and taken calorie
        graphView = view.findViewById(R.id.line_graph_view);
        calorieBurnt = view.findViewById(R.id.calorieBurnt);
        calorieTaken = view.findViewById(R.id.calorieTaken);
        submitCalories = (Button) view.findViewById(R.id.submit_button_progress_tracker);

        String takenValue = calorieTaken.getText().toString();
        String burntValue = calorieBurnt.getText().toString();

        Integer takenValueInt = Integer.parseInt(takenValue);
        Integer burntValueInt = Integer.parseInt(burntValue);

        int dailyIntake = takenValueInt - burntValueInt;
        ArrayList<Integer> dailyVal = new ArrayList<>();

        ArrayList<DataPoint> dataPoints = new ArrayList<>();

        submitCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int avgCalories = weeklyAvgCal(whichDay, dailyVal);
                daily_average_result.setText(avgCalories + "cal");

                if (whichDay == "Monday") {
                    dailyVal.clear();
                    dailyVal.add(dailyIntake);
                } else {
                    dailyVal.add(dailyIntake);
                }

                dataPoints.add(new DataPoint(x, dailyIntake));
            }
        });

        DataPoint[] dataPointsArr = new DataPoint[dataPoints.size()];
        dataPointsArr = dataPoints.toArray(dataPointsArr);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPointsArr);

        graphView.addSeries(series);

        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter()
        {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX){
                    int i = -1;
                    i += 1;
                    return daysInWeek[i] + super.formatLabel(value, isValueX);
                }
                return super.formatLabel(value, isValueX);
            }
        });

        return view;
    }

    private int weeklyAvgCal(String day, ArrayList<Integer> dailyVal) {
        int avg = 0;
        if (day == "Sunday") {
            for (int dailyEachVal : dailyVal) {
                avg += dailyEachVal;
            }
            return avg / 7;
        } else {
            return 0;
        }
    }
}