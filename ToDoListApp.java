import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    static class Task {
        String name;
        boolean isCompleted;

        Task(String name) {
            this.name = name;
            this.isCompleted = false;
        }
    }

    static class User {
        String name;
        int completedTasks;

        User(String name) {
            this.name = name;
            this.completedTasks = 0;
        }

        String getBadge() {
            if (completedTasks >= 20) {
                return "Hacker";
            } else if (completedTasks >= 10) {
                return "Pro";
            } else {
                return "Noob";
            }
        }

        void incrementCompletedTasks() {
            completedTasks++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama Anda: ");
        String userName = scanner.nextLine();
        User user = new User(userName);

        while (true) {
            System.out.println("\n===== Task Hero =====");
            System.out.println(user.name + " (" + user.getBadge() + ")");
            System.out.println("1. Tambahkan Tugas");
            System.out.println("2. Lihat Semua Tugas");
            System.out.println("3. Tandai Tugas Selesai");
            System.out.println("4. Hapus Tugas");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama tugas: ");
                    String taskName = scanner.nextLine();
                    tasks.add(new Task(taskName));
                    System.out.println("Tugas berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\nDaftar Tugas:");
                    if (tasks.isEmpty()) {
                        System.out.println("Tidak ada tugas saat ini.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            Task task = tasks.get(i);
                            String status = task.isCompleted ? "[Selesai]" : "[Belum Selesai]";
                            System.out.println((i + 1) + ". " + task.name + " " + status);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor tugas yang ingin ditandai selesai: ");
                    int completeIndex = scanner.nextInt() - 1;
                    if (completeIndex >= 0 && completeIndex < tasks.size()) {
                        Task task = tasks.get(completeIndex);
                        if (!task.isCompleted) {
                            task.isCompleted = true;
                            user.incrementCompletedTasks();
                            System.out.println("Tugas berhasil ditandai selesai!");
                        } else {
                            System.out.println("Tugas sudah selesai sebelumnya.");
                        }
                    } else {
                        System.out.println("Nomor tugas tidak valid.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nomor tugas yang ingin dihapus: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    if (deleteIndex >= 0 && deleteIndex < tasks.size()) {
                        tasks.remove(deleteIndex);
                        System.out.println("Tugas berhasil dihapus!");
                    } else {
                        System.out.println("Nomor tugas tidak valid.");
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi To-Do List!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}
