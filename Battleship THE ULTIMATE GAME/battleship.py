# STAVROS ANDRONIS, A.M:3181
import os
import random
import time


def position_validation(which_player, which_ship, dictionary_of_ships_positions, dictionary_for_validation):
    while True:
        try:
            variable = input("Player %s enter the position of your ship no%s:" % (which_player, which_ship))
            if variable in dictionary_of_ships_positions or variable not in dictionary_for_validation:
                raise ValueError
        except ValueError:
            print("\nInvalid position, or position already taken. Try again:")
        else:
            return variable


def starting_positions(num_of_pl, dictionary_of_validation):
    num_of_ships = 1
    player = {}
    while num_of_ships <= 5:
        given_location = position_validation(num_of_pl, num_of_ships, player, dictionary_of_validation)
        player[given_location] = ''
        num_of_ships += 1
    if ans != '1':
        os.system("cls||clear")
    return player


def make_dict(n, c, numbers):
    d = {}
    for i in range(n):
        while True:
            try:
                xar = random.choice(c) + random.choice(numbers)
                if xar in d:
                    raise ValueError
            except ValueError:
                continue
            else:
                break
        d[xar] = ''
    return d


def attack_validation(dictionary_of_targets, dictionary_of_valid_pos, num_of_player):
    while True:
        try:
            variable = input("Player %s enter the position to throw your missile: " % num_of_player)
            if variable in dictionary_of_targets or variable not in dictionary_of_valid_pos:
                raise ValueError
        except ValueError:
            print("Invalid position, or missile already thrown there. Try again:")
        else:
            return variable


def pc_attacking_strategy(list_of_targets_cpu, i, player_dictionary, disp_mat, dictionary_of_let, d_ships):
    x = list_of_targets_cpu[i]
    print("Missile thrown at ", x)
    hitted_targets = d_ships
    if x in player_dictionary:
        disp_mat[dictionary_of_let[x[0]]][int(x[1])-1] = 'o'
        hitted_targets += 1
        print("Target hit!")
    else:
        disp_mat[dictionary_of_let[x[0]]][int(x[1])-1] = 'x'
        print("Target missed!")
    return hitted_targets


def player_attacking_strategy(dictionary_of_targets, dictionary_of_ships_positions, dictionary_of_letters,
                              opponent_matrix, hitted_ships, dictionary_of_validation, num_of_player):
    counter_of_ships = hitted_ships
    variable = attack_validation(dictionary_of_targets, dictionary_of_validation, num_of_player)
    print("Missile thrown at", variable)
    dictionary_of_targets[variable] = ''
    if variable in dictionary_of_ships_positions:
        opponent_matrix[dictionary_of_letters[variable[0]]][int(variable[1])-1] = 'o'
        counter_of_ships += 1
        print("Target hit!")
    else:
        opponent_matrix[dictionary_of_letters[variable[0]]][int(variable[1])-1] = 'x'
        print("Target missed!")
    return counter_of_ships


def display_matrices(m1, m2, ch, choice):
    if choice is '1':
        print(2 * ' ', "P1", 8 * ' ', 'CPU')
        print(1 * ' ', '12345', 5 * ' ', '12345')
    else:
        print(2 * ' ', "P1", 8 * ' ', 'P2')
        print(1 * ' ', '12345', 5 * ' ', '12345')
    c = 0
    for i in ch:
        content1_row = ''.join(m1[c])
        content2_row = ''.join(m2[c])
        print(i, content1_row, ' ', ' ', i, content2_row)
        c += 1


def singleplayer_mode(mat1, mat2):
    char = ['a', 'b', 'c', 'd', 'e']
    let_to_num = {'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4}
    valid_inputs = {'a1', 'a2', 'a3', 'a4', 'a5', 'b1', 'b2', 'b3', 'b4', 'b5', 'c1', 'c2', 'c3', 'c4', 'c5', 'd1',
                    'd2', 'd3', 'd4', 'd5', 'e1', 'e2', 'e3', 'e4', 'e5'}
    num = ['1', '2', '3', '4', '5']
    cpu_ships = make_dict(5, char, num)
    player1_ships = starting_positions(1, valid_inputs)
    targets_cpu = make_dict(25, char, num)
    t = list(targets_cpu.keys())
    p1_targets = {}
    d_ships1 = 0
    d_shipscpu = 0
    players = [1, 'CPU']
    p = random.choice(players)
    print("Player%s starts first!" % p)
    display_matrices(mat1, mat2, char, '1')
    counter = 0
    while d_ships1 < 5 and d_shipscpu < 5:
        if p == 1:
            p = 2
            d_shipscpu = player_attacking_strategy(p1_targets, cpu_ships, let_to_num, mat2, d_shipscpu, valid_inputs, 1)
        else:
            p = 1
            d_ships1 = pc_attacking_strategy(t, counter, player1_ships, mat1, let_to_num, d_ships1)
            counter += 1
        display_matrices(mat1, mat2, char, '1')
    if d_ships1 == 5:
        print("Game Over!CPU won the game")
    else:
        print("Game Over!Player 1 won the game")


def two_players_mode(mat1, mat2):
    char = ['a', 'b', 'c', 'd', 'e']
    let_to_num = {'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4}
    valid_inputs = {'a1', 'a2', 'a3', 'a4', 'a5', 'b1', 'b2', 'b3', 'b4', 'b5', 'c1', 'c2', 'c3', 'c4', 'c5', 'd1',
                    'd2', 'd3', 'd4', 'd5', 'e1', 'e2', 'e3', 'e4', 'e5'}
    player1_ships = starting_positions(1, valid_inputs)
    player2_ships = starting_positions(2, valid_inputs)
    d_ships1 = 0
    d_ships2 = 0
    targets1 = {}
    targets2 = {}
    p = random.randint(1, 2)
    print("Player%s starts first!" % p)
    display_matrices(mat1, mat2, char, 2)
    while d_ships1 < 5 and d_ships2 < 5:
        if p == 1:
            d_ships2 = player_attacking_strategy(targets1, player2_ships, let_to_num, mat2, d_ships2, valid_inputs, p)
            p = 2
        else:
            d_ships1 = player_attacking_strategy(targets2, player1_ships, let_to_num, mat1, d_ships1, valid_inputs, p)
            p = 1
        display_matrices(mat1, mat2, char, 2)
    if d_ships2 == 5:
        print("Game Over!Player 1 won the game")
    else:
        print("Game Over!Player 2 won the game")


flag = True
while flag == True:
    starting_time = time.time()
    matrix1 = [[' ' for j in range(5)] for i in range(5)]
    matrix2 = [[' ' for f in range(5)] for g in range(5)]
    print("BATLESHIP GAME")
    print("The objective is to sink the opponent's ships before the opponent sinks yours.")
    while True:
        try:
            ans = input("Input 1 for 1-player game or 2 for 2-player game: \t")
            if ans != '1' and ans != '2':
                raise ValueError
        except ValueError:
            print("ValueError!Try again!")
        else:
            break
    if ans == '1':
        singleplayer_mode(matrix1, matrix2)
    else:
        two_players_mode(matrix1, matrix2)
    finished_time = time.time()
    execution_time = finished_time - starting_time
    flag = input("Program finished!Game Time: %.2f seconds " % execution_time)
