package com.example.a9lab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import android.widget.LinearLayout.LayoutParams; // Импортируем правильный класс LayoutParams

public class MainActivity extends AppCompatActivity {
    private ImageView circleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleImage = findViewById(R.id.circle_image); // Пример id вашего изображения круга

        setSupportActionBar(findViewById(R.id.toolbar));

        // Регистрируем контекстное меню для изображения круга
        registerForContextMenu(circleImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.move_left_option) {
            moveCircle(-20); // Смещаем круг влево на 20 пикселей
            return true;
        } else if (itemId == R.id.move_right_option) {
            moveCircle(20); // Смещаем круг вправо на 20 пикселей
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void moveCircle(int offsetX) {
        // Получаем текущие параметры LayoutParams
        LayoutParams layoutParams = (LayoutParams) circleImage.getLayoutParams();
        layoutParams.leftMargin += offsetX;
        circleImage.setLayoutParams(layoutParams);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Изменить размер круга");
        menu.add(0, 1, 0, "Маленький круг");
        menu.add(0, 2, 0, "Средний круг");
        menu.add(0, 3, 0, "Большой круг");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == 1) {
            resizeCircle(100); // Меняем размер круга на маленький
            return true;
        } else if (itemId == 2) {
            resizeCircle(200); // Меняем размер круга на средний
            return true;
        } else if (itemId == 3) {
            resizeCircle(300); // Меняем размер круга на большой
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    private void resizeCircle(int size) {
        // Получаем текущие параметры LayoutParams
        LayoutParams layoutParams = (LayoutParams) circleImage.getLayoutParams();
        layoutParams.width = size;
        layoutParams.height = size;
        circleImage.setLayoutParams(layoutParams);
    }
}
