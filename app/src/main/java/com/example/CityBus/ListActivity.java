package com.example.CityBus;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CityBus.database.BusModel;
import com.example.CityBus.database.DatabaseAccess;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends Activity {
    public  static String to;

    private static final String [] routestrings = new String[]
            {"Nazimabad", "BaraMaidan", "Lasbela", "LawrenceRoad", "BarnessStreet", "BandarRoad", "Tower", "M.P.RColony",
                    "QasbaColony",
                    "BanarasColony",
                    "PathanColony",
                    "S.I.T.E",
                    "HabibBank",
                    "BismillahHotel",
                    "GandhiGarden",
                    "GardenRoad",
                    "Plaza",
                    "Regal",
                    "Shahra-e-Liaquat",
                    "NationalMuseum",
                    "Tower",
                    "Sultanabad",
                    "NavalColony",
                    "Mauripur",
                    "GulbaiChowk",
                    "Tower",
                    "JunaMarket",
                    "Ramswami",
                    "GardenBaraBoard",
                    "Valika",
                    "OrangiTownshipNo.10",
                    "M.WTower",
                    "FrereRoad",
                    "Sadar",
                    "Numaish",
                    "GoroMandir",
                    "TeenHatti",
                    "LiaquatNo.10",
                    "PetrolPump",
                    "NazimabadNo.2",
                    "GandhiChowk",
                    "PaposhNagar",
                    "AbdullahCollege",
                    "MetroCinema",
                    "DataChowkOrangiTown",
                    "AzamBasti",
                    "Corporation",
                    "Kalapul",
                    "JinnahHospital",
                    "Saddar",
                    "7thDayHospital",
                    "Numaish",
                    "GuruMandir",
                    "IslamiaCollege",
                    "JailRoad",
                    "NewTownPoliceStation",
                    "SabziMandi",
                    "CivicCentre",
                    "UrduCollege",
                    "N.I.P.AChowrangi",
                    "SafariPark",
                    "UniversityRoad",
                    "SafooraGoth",
                    "FederalB.Area",
                    "NooraniMasjid",
                    "PeoplesColony",
                    "ImamBara",
                    "HumayunRoad",
                    "K.D.AOffice",
                    "NorthNazimabad",
                    "BoardOffice",
                    "NazimabadNo.7",
                    "PetrolPump",
                    "Lasbella",
                    "SabilWaliMasjid",
                    "SoldierBazar",
                    "Saddar",
                    "FrereRoad",
                    "M.WTower",
                    "NooraniMasjid",
                    "BabarMarket",
                    "LandhiNo.31/2",
                    "LandhiNo.5",
                    "KorangiNo.6",
                    "KorangiNo.5",
                    "KorangiNo.3",
                    "KorangiNo.1",
                    "KorangiCrossing",
                    "Qayumabad",
                    "AkhtakColony",
                    "DefenceSociety",
                    "KalaPul",
                    "JinnahHospital",
                    "LuckStarHotel",
                    "HijazDairyFarm",
                    "NorthNazimabadBlockM",
                    "Shahra-e-Jehangir",
                    "WaterPump",
                    "Hyderi",
                    "PaposhNagar",
                    "BaraMaidan",
                    "NazimabadNo.2",
                    "PetrolPump",
                    "GuruMandir",
                    "Saddar",
                    "BurnsRoad",
                    "MereweatherTower",
                    "Keamari",
                    "Rashidabad",
                    "BiharColony",
                    "GhaniChowrangi",
                    "Shershah",
                    "Chakiwara",
                    "LeeMarket",
                    "HerchandraiRoad",
                    "HajicampRoad",
                    "NishterRoad",
                    "Baba-e-urdu",
                    "FrereRoad",
                    "CourtRoad",
                    "SarwarshaheedRoad",
                    "Shahrah-e-iraq",
                    "Masjid-e-khizra",
                    "BurnsRoad",
                    "M.AjinnahRoad",
                    "CanttStation",
                    "AgratajColony",
                    "Kalri",
                    "Baghdadi",
                    "Meesalane",
                    "Kharadar",
                    "KhajeerBazar",
                    "LeaMarket",
                    "Puranihajicamp",
                    "Ranchorelines",
                    "ShoMarket",
                    "Garden",
                    "Pakistanquaters",
                    "Khajajamatkhana",
                    "Lasbela",
                    "Teenhatti",
                    "NewTown",
                    "Liaquathospital",
                    "Dhorajisociety",
                    "Nationalstadium",
                    "NationalCementFactory",
                    "NavalQuaters",
                    "LabourQuaters",
                    "DrighRoad",
                    "NathakhanGoth",
                    "AirPort",
                    "Malir",
                    "Landhi",
                    "Quaidabad",
                    "QazafiTown",
                    "NewKarachiBlock5-F",
                    "IndustrialArea",
                    "Karimabad",
                    "Liaquatabad",
                    "TeenHatti",
                    "GoroMandir",
                    "M.AJinnahRoad",
                    "BandarRoad",
                    "PreedyStreet",
                    "PoliceStation",
                    "Saddar",
                    "ShirinjinnahColony",
                    "Clifton",
                    "Mehatapalace",
                    "Cliftonbridge",
                    "Bagh-e-jinnah",
                    "Metropolehotel",
                    "Luckystar",
                    "Saddar",
                    "Garden",
                    "Oldgolimar",
                    "BaraBoard",
                    "Habibbank",
                    "Valikastop",
                    "PoliceStation",
                    "S.I.T.E",
                    "Laboursquare",
                    "Rashidabad",
                    "IttehadTown",
                    "TorriChowkSectorII",
                    "OrangiTownship",
                    "BanarasColony",
                    "PathanColony",
                    "PetrolPump",
                    "LiaquatabadNo.10",
                    "Liaquatabad",
                    "PostOffice",
                    "TeenHatti",
                    "JehangirRoad",
                    "EmpressMarket",
                    "CanttStation",
                    "Nazimabad",
                    "BaraMaidan",
                    "Lasbela",
                    "LawrenceRoad",
                    "BarnessStreet",
                    "BandarRoad",
                    "Tower",
                    "M.P.RColony",
                    "QasbaColony",
                    "BanarasColony",
                    "PathanColony",
                    "S.I.T.E",
                    "HabibBank",
                    "BismillahHotel",
                    "GandhiGarden",
                    "GardenRoad",
                    "Plaza",
                    "Regal",
                    "Shahra-e-Liaquat",
                    "NationalMuseum",
                    "Tower",
                    "Sultanabad",
                    "NavalColony",
                    "Mauripur",
                    "GulbaiChowk",
                    "Tower",
                    "JunaMarket",
                    "Ramswami",
                    "GardenBaraBoard",
                    "Valika",
                    "OrangiTownshipNo.10",
                    "M.WTower",
                    "FrereRoad",
                    "Sadar",
                    "Numaish",
                    "GoroMandir",
                    "TeenHatti",
                    "LiaquatNo.10",
                    "PetrolPump",
                    "NazimabadNo.2",
                    "GandhiChowk",
                    "PaposhNagar",
                    "AbdullahCollege",
                    "MetroCinema",
                    "DataChowkOrangiTown",
                    "AzamBasti",
                    "Corporation",
                    "Kalapul",
                    "JinnahHospital",
                    "Saddar",
                    "7thDayHospital",
                    "Numaish",
                    "GuruMandir",
                    "IslamiaCollege",
                    "JailRoad",
                    "NewTownPoliceStation",
                    "SabziMandi",
                    "CivicCentre",
                    "UrduCollege",
                    "N.I.P.AChowrangi",
                    "SafariPark",
                    "UniversityRoad",
                    "SafooraGoth",
                    "FederalB.Area",
                    "NooraniMasjid",
                    "PeoplesColony",
                    "ImamBara",
                    "HumayunRoad",
                    "K.D.AOffice",
                    "NorthNazimabad",
                    "BoardOffice",
                    "NazimabadNo.7",
                    "PetrolPump",
                    "Lasbella",
                    "SabilWaliMasjid",
                    "SoldierBazar",
                    "Saddar",
                    "FrereRoad",
                    "M.WTower",
                    "NooraniMasjid",
                    "BabarMarket",
                    "LandhiNo.31/2",
                    "LandhiNo.5",
                    "KorangiNo.6",
                    "KorangiNo.5",
                    "KorangiNo.3",
                    "KorangiNo.1",
                    "KorangiCrossing",
                    "Qayumabad",
                    "AkhtakColony",
                    "DefenceSociety",
                    "KalaPul",
                    "JinnahHospital",
                    "LuckStarHotel",
                    "HijazDairyFarm",
                    "NorthNazimabadBlockM",
                    "Shahra-e-Jehangir",
                    "WaterPump",
                    "Hyderi",
                    "PaposhNagar",
                    "BaraMaidan",
                    "NazimabadNo.2",
                    "PetrolPump",
                    "GuruMandir",
                    "Saddar",
                    "BurnsRoad",
                    "MereweatherTower",
                    "Keamari",
                    "Rashidabad",
                    "BiharColony",
                    "GhaniChowrangi",
                    "Shershah",
                    "Chakiwara",
                    "LeeMarket",
                    "HerchandraiRoad",
                    "HajicampRoad",
                    "NishterRoad",
                    "Baba-e-urdu",
                    "FrereRoad",
                    "CourtRoad",
                    "SarwarshaheedRoad",
                    "Shahrah-e-iraq",
                    "Masjid-e-khizra",
                    "BurnsRoad",
                    "M.AjinnahRoad",
                    "CanttStation",
                    "AgratajColony",
                    "Kalri",
                    "Baghdadi",
                    "Meesalane",
                    "Kharadar",
                    "KhajeerBazar",
                    "LeaMarket",
                    "Puranihajicamp",
                    "Ranchorelines",
                    "ShoMarket",
                    "Garden",
                    "Pakistanquaters",
                    "Khajajamatkhana",
                    "Lasbela",
                    "Teenhatti",
                    "NewTown",
                    "Liaquathospital",
                    "Dhorajisociety",
                    "Nationalstadium",
                    "NationalCementFactory",
                    "NavalQuaters",
                    "LabourQuaters",
                    "DrighRoad",
                    "NathakhanGoth",
                    "AirPort",
                    "Malir",
                    "Landhi",
                    "Quaidabad",
                    "QazafiTown",
                    "NewKarachiBlock5-F",
                    "IndustrialArea",
                    "Karimabad",
                    "Liaquatabad",
                    "TeenHatti",
                    "GoroMandir",
                    "M.AJinnahRoad",
                    "BandarRoad",
                    "PreedyStreet",
                    "PoliceStation",
                    "Saddar",
                    "ShirinjinnahColony",
                    "Clifton",
                    "Mehatapalace",
                    "Cliftonbridge",
                    "Bagh-e-jinnah",
                    "Metropolehotel",
                    "Luckystar",
                    "Saddar",
                    "Garden",
                    "Oldgolimar",
                    "BaraBoard",
                    "Habibbank",
                    "Valikastop",
                    "PoliceStation",
                    "S.I.T.E",
                    "Laboursquare",
                    "Rashidabad",
                    "IttehadTown",
                    "TorriChowkSectorII",
                    "OrangiTownship",
                    "BanarasColony",
                    "PathanColony",
                    "PetrolPump",
                    "LiaquatabadNo.10",
                    "Liaquatabad",
                    "PostOffice",
                    "TeenHatti",
                    "JehangirRoad",
                    "EmpressMarket",
                    "CanttStation",
                    "Golimar", "Power House","Business Recorder Road","Nazimabad Board","Surjani Town","Guru Mandar",
                    "Five Star Chowrangi","UP Mor","Hydri Market","Mazar-e-Quaid","Nagan Chowrangi"," "," "," "," "," "

            };

    AutoCompleteTextView e1,e2;
    RecyclerView recyclerView;
    ArrayList<String> busnumb;
    ArrayList<String> froms;
    ArrayList<String> tos;
    ArrayList<String> routes;
    BusDataAdapter adapter;
    ArrayList<String> SLL;
    ArrayList<String> DLL;
    ArrayList<String> PLL;
    ArrayList<String> at;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        e1 = (AutoCompleteTextView) findViewById(R.id.source);
        e2 = (AutoCompleteTextView) findViewById(R.id.destination);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1,routestrings);
        e1.setAdapter(adap);
        e2.setAdapter(adap);
        recyclerView = findViewById(R.id.rv_buses);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        busnumb = new ArrayList<>();
        froms = new ArrayList<>();
        tos = new ArrayList<>();
        routes= new ArrayList<>();
        SLL = new ArrayList<>();
        DLL = new ArrayList<>();
        PLL = new ArrayList<>();
        at = new ArrayList<>();



    }

    public void getroutes(View view) {
        DatabaseAccess databaseAccess =DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        String from = e1.getText().toString().trim();
         to = e2.getText().toString().trim();


        Cursor busdata = databaseAccess.getBusData(from,to);
        if(busdata.getCount()==0){
            Toast.makeText(this, "Not Found", Toast.LENGTH_LONG).show();
        }
        else{
            while(busdata.moveToNext()){
                busnumb.add(busdata.getString(0));
                froms.add(busdata.getString(1));
                tos.add(busdata.getString(3));


                System.out.println("details bus :"+busdata.getString(2));
                System.out.println("details bus4 :"+busdata.getString(4));
                System.out.println("details bus6 :"+busdata.getString(6));

                SLL.add(busdata.getString(2));
                DLL.add(busdata.getString(4));

                PLL.add(busdata.getString(6));
                at.add(busdata.getString(7));

            }
        }
        adapter = new BusDataAdapter(ListActivity.this,busnumb,froms,tos,SLL,DLL,PLL,at);
        recyclerView.setAdapter(adapter);
        databaseAccess.close();
    }
}
