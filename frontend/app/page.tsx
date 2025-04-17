import Image from "next/image";

export default function Home() {
  return (
    <div>
      <header>
        <h1>Welcome to My Diary App</h1>
        <nav>
          <button>Go to Calendar</button>
        </nav>
      </header>

      <main>
        <h2>Today's Diary</h2>
        <p>Write something here...</p>
        <button>Write a new entry</button>
      </main>

      <footer>
        <p>&copy; 2025 My Diary App</p>
      </footer>
    </div>
  );
}
