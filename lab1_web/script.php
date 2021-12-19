<?php
makeAnswer();
function sessionWork($t)
{
    session_start();

    if ($t != 2) {
        if (isset($_SESSION['LAST_ACTIVITY']) && (time() - $_SESSION['LAST_ACTIVITY'] > 60 * 15)) {
            session_unset();
            session_destroy();
        }
        $_SESSION['LAST_ACTIVITY'] = time();
    } else {
        session_unset();
        session_destroy();
    }

    if (!isset($_SESSION['answer'])) {
        $_SESSION['answer'] = array();
        $_SESSION['number'] = 0;

    }

}

function makeAnswer()
{
    if (isset($_GET['t'])) {
        if ($_GET['t'] == 1) {
            sessionWork(1);
            handleNumbers();
        } else if ($_GET['t'] == 2) {
            sessionWork(2);
            array_unshift($_SESSION['answer'], "<tr><td>Данных пока нет</td>
    <td>Данных пока нет</td>
    <td>Данных пока нет</td>
    <td>Данных пока нет</td>
    <td>Данных пока нет</td>
    <td>Данных пока нет</td></tr>");
            printTable();
        }
    }
}


function handleNumbers()
{
    $startTime = microtime(true);

    if (isset($_GET['x']) && isset($_GET['y']) && isset($_GET['r'])) {
        $x = $_GET['x'];
        $y = $_GET['y'];
        $r = $_GET['r'];
        $isInArea = (checkGetInto($x, $y, $r)) ? "Да" : "Нет";
        $time = microtime(true) - $startTime;
        $_SESSION['number']++;
        if (validate($x, $y, $r)) {
            array_unshift($_SESSION['answer'], "<tr><td>" . $_SESSION['number'] . "</td>
    <td>" . $isInArea . "</td>
    <td>" . $r . "</td>
    <td>" . $x . "</td>
    <td>" . $y . "</td>
    <td>" . $time . " мкс</td></tr>");
            printTable();
        } else {
            array_unshift($_SESSION['answer'], "<tr><td>" . $_SESSION['number'] . "</td>
    <td>Ошибка валидности</td>
    <td>Ошибка валидности</td>
    <td>Ошибка валидности</td>
    <td>Ошибка валидности</td>
    <td>Ошибка валидности</td></tr>");
            printTable();
        }
    }
}

$x;
$y;
$r;

function validate($vX, $vY, $vR)
{
    $x = $vX;
    $y = str_replace(",", ".",$vY);   
    $r = $vR;
    return (is_numeric($x) && is_numeric($r) && (is_numeric($y) && ($y < 3 && $y > -5)));
}

function printTable()
{
    echo "<tr>
                   <td colspan='2'>
                      <button type='button' id='clrBtn'>Очистить сессию</button>
                  </td>
              </tr>";
    echo "<table id=\"table-result\"><thead>";
    echo "<tr><th>№</th>
        <th>Точка в зоне</th>
        <th>R</th>
        <th>X</th>
        <th>Y</th>
        <th>Время обработки</th></tr>
        </thead>
        <tbody>";
    foreach ($_SESSION['answer'] as $element) echo $element;

    echo "</tbody></table>";
}

function checkGetInto($x, $y, $r)
{
    if ($y <= $r && $y >= 0 && $x <= 0 && $x >= -$r) {
        return true;
    } else if (($y <= $r / 2 && $y >= 0 && $x >= 0 && $x <= ($r / 2)) && ((($x * $y) / 2) <= (($r * $r) / 8))) {
        return true;
    } else if (($y >= -$r && $y <= 0 && $x >= 0 && $x <= $r) && (($x * $x + $y * $y) <= $r * $r)) {
        return true;
    } else {
        return false;
    }
}

?>