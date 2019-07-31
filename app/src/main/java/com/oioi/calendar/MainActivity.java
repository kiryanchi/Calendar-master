package com.oioi.calendar;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    TextView SaveMyDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
        navView.setOnNavigationItemSelectedListener(BottomItemSelectedListener);

    }

        private BottomNavigationView.OnNavigationItemSelectedListener BottomItemSelectedListener = // BottomNavigationView 리스너 부분
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) { //NavigationView 에서 각각의 아이템이 선택되었을 때 실행할 이벤트를 Switch-Case 문으로 구성
                        Fragment selectedFragment = null;
                            switch(menuItem.getItemId()){
                                case R.id.nav_Home:
                                    selectedFragment = new HomeFragment();
                                    break;
                                case R.id.nav_Suggest:
                                    selectedFragment = new Suggestion_and_SearchFragment();
                                    break;
                                case R.id.nav_Chat:
                                    selectedFragment = new ChattingFragment();
                                    break;
                            }

                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();//선택한 아이템에 해당하는 fragment 로 이동
                            return true;
                        }
                };
        }
