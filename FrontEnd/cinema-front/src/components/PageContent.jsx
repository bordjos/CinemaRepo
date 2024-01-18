import classes from "./PageContent.module.css";

export default function PageContent({ title, children }) {
  return (
    <>
      {title === "Not found!" ? (
        <div className={classes.container}>
          <div className={classes.centeredContent}>
            <img src="https://i.imgur.com/A040Lxr.png" />
            <div id="info">
              <h1>This Page is Lost in Space</h1>
              <p className={classes.text}>
                You thought this mission to the moon would be a quick six month
                thing. Pretty devastating.
              </p>
            </div>
          </div>
        </div>
      ) : (
        <div className={classes.content}>
          <h1>{title}</h1>
          {children}
        </div>
      )}
    </>
  );
}
