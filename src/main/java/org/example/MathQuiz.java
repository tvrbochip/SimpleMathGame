package org.example;

import java.util.Random;
import java.util.Scanner;

public class MathQuiz {
    private static class Question {
        private int number1;
        private int number2;
        private char operator;
        private int correctAnswer;
        public Question() {
            Random random = new Random();
            number1 = random.nextInt(16);
            number2 = random.nextInt(16);
            operator = random.nextBoolean() ? '+' : '-';
            calculateCorrectAnswer();
        }

        private void calculateCorrectAnswer() {
            if (operator == '+') {
                correctAnswer = number1 + number2;
            } else {
                correctAnswer = number1 - number2;
            }
        }

        public String getQuestionText() {
            return number1 + " " + operator + " " + number2 + " = ???";
        }

        public int getCorrectAnswer() {
            return correctAnswer;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Привет! Как вас зовут?");
        String name = scanner.nextLine();
        System.out.println("Приятно познакомиться, " + name + "!");

        int correctAnswers = 0;
        int totalQuestions = 0;
        long startGameTime = System.currentTimeMillis();

        for (int i = 0; i < 40; i++) {
            Question question = new Question();
            System.out.println(question.getQuestionText());

            long startTime = System.currentTimeMillis();
            int userAnswer = scanner.nextInt();
            long endTime = System.currentTimeMillis();
            double elapsedTime = (endTime - startTime) / 1000.0;

            if (userAnswer == question.getCorrectAnswer()) {
                System.out.println("Вы правильно ответили!");
                correctAnswers++;
            } else {
                System.out.println("Извините, правильный ответ: " + question.getCorrectAnswer());
            }

            totalQuestions++;
            System.out.println("Время на ответ: " + String.format("%.2f", elapsedTime) + " сек.");
        }

        long endGameTime = System.currentTimeMillis();
        double totalGameTime = (endGameTime - startGameTime) / 1000.0;

        System.out.println("Игра завершена!");
        System.out.println("Общее время игры: " + String.format("%.2f", totalGameTime) + " сек.");
        System.out.println("Правильных ответов: " + correctAnswers);
        System.out.println("Общее количество вопросов: " + totalQuestions);

        scanner.close();
    }
}
